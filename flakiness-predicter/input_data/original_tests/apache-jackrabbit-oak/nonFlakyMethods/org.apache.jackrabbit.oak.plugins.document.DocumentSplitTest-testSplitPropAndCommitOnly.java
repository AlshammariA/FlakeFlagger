@Test public void testSplitPropAndCommitOnly() throws Exception {
  DocumentStore store=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  NodeBuilder b1=ns.getRoot().builder();
  b1.child("test").child("foo").child("bar");
  ns.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  for (int i=0; i < NodeDocument.NUM_REVS_THRESHOLD; i++) {
    b1=ns.getRoot().builder();
    b1.child("test").child("foo").setProperty("prop",i);
    b1.child("test").setProperty("prop",i);
    ns.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  }
  ns.runBackgroundOperations();
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/test/foo"));
  List<NodeDocument> prevDocs=ImmutableList.copyOf(doc.getAllPreviousDocs());
  assertEquals(1,prevDocs.size());
  assertEquals(SplitDocType.PROP_COMMIT_ONLY,prevDocs.get(0).getSplitDocType());
}
