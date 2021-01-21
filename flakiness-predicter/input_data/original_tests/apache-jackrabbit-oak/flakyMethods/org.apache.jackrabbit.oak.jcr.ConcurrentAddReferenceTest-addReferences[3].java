@SuppressWarnings("unchecked") @Test public void addReferences() throws Exception {
  List<Exception> exceptions=Collections.synchronizedList(new ArrayList<Exception>());
  List<Thread> worker=new ArrayList<Thread>();
  for (int i=0; i < NUM_WORKERS; i++) {
    String path=testRoot.addNode("node" + i).getPath();
    worker.add(new Thread(new Worker(createAdminSession(),path,exceptions)));
  }
  getAdminSession().save();
  for (  Thread t : worker) {
    t.start();
  }
  for (  Thread t : worker) {
    t.join();
  }
  for (  Exception e : exceptions) {
    fail(e.toString());
  }
  getAdminSession().refresh(false);
  for (  Node n : in((Iterator<Node>)testRoot.getNodes())) {
    assertEquals(NODES_PER_WORKER,Iterators.size(n.getNodes()));
  }
}
