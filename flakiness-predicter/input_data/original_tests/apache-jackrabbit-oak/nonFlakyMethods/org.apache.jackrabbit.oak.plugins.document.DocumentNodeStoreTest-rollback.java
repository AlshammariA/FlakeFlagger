@Test public void rollback() throws Exception {
  final Map<Thread,Semaphore> locks=Collections.synchronizedMap(new HashMap<Thread,Semaphore>());
  final Semaphore created=new Semaphore(0);
  DocumentStore docStore=new MemoryDocumentStore(){
    @Override public <T extends Document>boolean create(    Collection<T> collection,    List<UpdateOp> updateOps){
      Semaphore semaphore=locks.get(Thread.currentThread());
      boolean result=super.create(collection,updateOps);
      if (semaphore != null) {
        created.release();
        semaphore.acquireUninterruptibly();
      }
      return result;
    }
  }
;
  final List<Exception> exceptions=new ArrayList<Exception>();
  final DocumentMK mk=new DocumentMK.Builder().setDocumentStore(docStore).setAsyncDelay(0).open();
  final DocumentNodeStore store=mk.getNodeStore();
  final String head=mk.commit("/","+\"foo\":{}+\"bar\":{}",null,null);
  Thread writer=new Thread(new Runnable(){
    @Override public void run(){
      try {
        Revision r=store.newRevision();
        Commit c=new Commit(store,Revision.fromString(head),r);
        c.addNode(new DocumentNodeState(store,"/foo/node",r));
        c.addNode(new DocumentNodeState(store,"/bar/node",r));
        c.apply();
      }
 catch (      MicroKernelException e) {
        exceptions.add(e);
      }
    }
  }
);
  final Semaphore s=new Semaphore(0);
  locks.put(writer,s);
  writer.start();
  created.acquireUninterruptibly();
  Revision r=store.newRevision();
  Commit c=new Commit(store,Revision.fromString(head),r);
  c.addNode(new DocumentNodeState(store,"/foo/node",r));
  c.addNode(new DocumentNodeState(store,"/bar/node",r));
  c.apply();
  s.release();
  writer.join();
  assertEquals("expected exception",1,exceptions.size());
  String id=Utils.getIdFromPath("/foo/node");
  NodeDocument doc=docStore.find(Collection.NODES,id);
  assertNotNull("document with id " + id + " does not exist",doc);
  assertTrue(!doc.getLastRev().isEmpty());
  id=Utils.getIdFromPath("/bar/node");
  doc=docStore.find(Collection.NODES,id);
  assertNotNull("document with id " + id + " does not exist",doc);
  assertTrue(!doc.getLastRev().isEmpty());
  mk.dispose();
}
