@Test public void addLotsOfNodes() throws Exception {
  char[] nPrefix=new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
  int nNodes=NODE_COUNT;
  for (int nThreads=1; nThreads < 32; nThreads=nThreads * 2) {
    DocumentStore docStore=openDocumentStore();
    dropCollections();
    log("Adding and updating " + nNodes + " nodes in each "+ nThreads+ " threads");
    long start=System.currentTimeMillis();
    ExecutorService executor=Executors.newFixedThreadPool(nThreads);
    for (int j=0; j < nThreads; j++) {
      executor.submit(new AddAndUpdateNodesTask(docStore,"node" + nPrefix[j],nNodes));
    }
    executor.shutdown();
    executor.awaitTermination(1,TimeUnit.MINUTES);
    long end=System.currentTimeMillis();
    log("Done: " + (end - start) + "ms");
  }
}
