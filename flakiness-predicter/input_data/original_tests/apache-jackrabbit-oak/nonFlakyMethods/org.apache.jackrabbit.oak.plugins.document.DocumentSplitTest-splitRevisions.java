@Test public void splitRevisions() throws Exception {
  DocumentStore store=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  Set<Revision> revisions=Sets.newHashSet();
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/"));
  assertNotNull(doc);
  revisions.addAll(doc.getLocalRevisions().keySet());
  revisions.add(Revision.fromString(mk.commit("/","+\"foo\":{}+\"bar\":{}",null,null)));
  while (revisions.size() <= NodeDocument.NUM_REVS_THRESHOLD) {
    revisions.add(Revision.fromString(mk.commit("/","+\"foo/node-" + revisions.size() + "\":{}"+ "+\"bar/node-"+ revisions.size()+ "\":{}",null,null)));
  }
  mk.runBackgroundOperations();
  String head=mk.getHeadRevision();
  doc=store.find(NODES,Utils.getIdFromPath("/"));
  assertNotNull(doc);
  Map<Revision,String> revs=doc.getLocalRevisions();
  assertEquals(1,revs.size());
  for (  Revision rev : revisions) {
    assertTrue(doc.containsRevision(rev));
    assertTrue(doc.isCommitted(rev));
  }
  assertNotNull(ns.getNode("/",Revision.fromString(head)));
  NodeDocument prevDoc=Iterators.getOnlyElement(doc.getAllPreviousDocs());
  assertEquals(SplitDocType.DEFAULT,prevDoc.getSplitDocType());
  mk.commit("/","+\"baz\":{}",null,null);
  ns.setAsyncDelay(0);
  mk.backgroundWrite();
}
