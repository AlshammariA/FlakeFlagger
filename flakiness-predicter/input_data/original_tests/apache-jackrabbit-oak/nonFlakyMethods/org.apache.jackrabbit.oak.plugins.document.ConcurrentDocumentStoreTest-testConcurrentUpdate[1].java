@Test public void testConcurrentUpdate() throws Exception {
  int workers=20;
  String id=this.getClass().getName() + ".testConcurrentUpdate";
  UpdateOp up=new UpdateOp(id,true);
  up.set("_id",id);
  up.set("thread",Thread.currentThread().getName());
  up.set("counter",0L);
  ds.create(Collection.NODES,Collections.singletonList(up));
  super.removeMe.add(id);
  List<Exception> exceptions=Collections.synchronizedList(new ArrayList<Exception>());
  List<Thread> worker=new ArrayList<Thread>();
  for (int i=0; i < workers; i++) {
    worker.add(new Thread(new Worker(id,false,exceptions)));
  }
  for (  Thread t : worker) {
    t.start();
  }
  for (  Thread t : worker) {
    t.join();
  }
  for (  Exception e : exceptions) {
    fail(e.toString());
  }
  Document d=ds.find(Collection.NODES,id);
  String val=d.get("counter").toString();
  org.junit.Assert.assertEquals("counter property not updated as expected",Integer.toString(workers),val);
}
