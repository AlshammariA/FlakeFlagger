@Test public void testConcurrenCreateOrUpdate() throws Exception {
  int workers=8;
  String id=this.getClass().getName() + ".testConcurrentCreateOrUpdate";
  super.removeMe.add(id);
  List<Exception> exceptions=Collections.synchronizedList(new ArrayList<Exception>());
  List<Thread> worker=new ArrayList<Thread>();
  for (int i=0; i < workers; i++) {
    worker.add(new Thread(new Worker(id,true,exceptions)));
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
