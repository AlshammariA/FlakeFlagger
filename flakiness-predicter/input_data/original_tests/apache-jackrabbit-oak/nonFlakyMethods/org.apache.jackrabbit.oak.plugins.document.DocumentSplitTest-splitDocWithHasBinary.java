@Test public void splitDocWithHasBinary() throws Exception {
  DocumentStore store=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  NodeBuilder b1=ns.getRoot().builder();
  b1.child("test").child("foo").setProperty("binaryProp",ns.createBlob(randomStream(1,4096)));
  ;
  ns.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  for (int i=0; i < NodeDocument.NUM_REVS_THRESHOLD; i++) {
    b1=ns.getRoot().builder();
    b1.child("test").child("foo").setProperty("prop",i);
    ns.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  }
  ns.runBackgroundOperations();
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/test/foo"));
  List<NodeDocument> prevDocs=ImmutableList.copyOf(doc.getAllPreviousDocs());
  assertEquals(1,prevDocs.size());
  assertTrue(doc.hasBinary());
  assertTrue(prevDocs.get(0).hasBinary());
}
