@Test public void testSplitDocNoChild() throws Exception {
  DocumentStore store=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  mk.commit("/","+\"test\":{\"node\":{}}",null,null);
  mk.commit("/test","+\"foo\":{}+\"bar\":{}",null,null);
  for (int i=0; i < NodeDocument.NUM_REVS_THRESHOLD; i++) {
    mk.commit("/test/foo","^\"prop\":" + i,null,null);
  }
  ns.runBackgroundOperations();
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/test/foo"));
  List<NodeDocument> prevDocs=ImmutableList.copyOf(doc.getAllPreviousDocs());
  assertEquals(1,prevDocs.size());
  assertEquals(SplitDocType.DEFAULT_NO_CHILD,prevDocs.get(0).getSplitDocType());
}
