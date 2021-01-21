@Test public void getNewestRevision() throws Exception {
  DocumentStore docStore=new MemoryDocumentStore();
  DocumentNodeStore ns1=new DocumentMK.Builder().setDocumentStore(docStore).setAsyncDelay(0).setClusterId(1).getNodeStore();
  ns1.getRoot();
  ns1.runBackgroundOperations();
  DocumentNodeStore ns2=new DocumentMK.Builder().setDocumentStore(docStore).setAsyncDelay(0).setClusterId(2).getNodeStore();
  ns2.getRoot();
  NodeBuilder b1=ns1.getRoot().builder();
  for (int i=0; i < NodeDocument.NUM_REVS_THRESHOLD; i++) {
    b1.setProperty("p",String.valueOf(i));
    ns1.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  }
  ns1.runBackgroundOperations();
  NodeBuilder b2=ns2.getRoot().builder();
  b2.setProperty("q","value");
  ns2.merge(b2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  ns1.dispose();
  ns2.dispose();
}
