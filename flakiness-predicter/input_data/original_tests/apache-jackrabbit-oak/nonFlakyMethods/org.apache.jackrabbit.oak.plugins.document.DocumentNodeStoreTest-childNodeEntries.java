@Test public void childNodeEntries() throws Exception {
  final AtomicInteger counter=new AtomicInteger();
  DocumentStore docStore=new MemoryDocumentStore(){
    @Nonnull @Override public <T extends Document>List<T> query(    Collection<T> collection,    String fromKey,    String toKey,    int limit){
      counter.incrementAndGet();
      return super.query(collection,fromKey,toKey,limit);
    }
  }
;
  DocumentNodeStore store=new DocumentMK.Builder().setDocumentStore(docStore).getNodeStore();
  NodeBuilder root=store.getRoot().builder();
  for (int i=0; i < 10; i++) {
    root.child("node-" + i);
  }
  store.merge(root,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  counter.set(0);
  for (  ChildNodeEntry e : store.getRoot().getChildNodeEntries()) {
    e.getNodeState();
  }
  assertEquals(1,counter.get());
  counter.set(0);
  for (  ChildNodeEntry e : store.getRoot().getChildNodeEntries()) {
    e.getNodeState();
  }
  assertEquals(0,counter.get());
  store.dispose();
}
