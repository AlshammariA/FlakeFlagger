@Test public void splitPropertyRevisions() throws Exception {
  DocumentStore store=mk.getDocumentStore();
  mk.commit("/","+\"foo\":{}",null,null);
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/foo"));
  assertNotNull(doc);
  Set<Revision> revisions=Sets.newHashSet();
  while (revisions.size() <= NodeDocument.NUM_REVS_THRESHOLD) {
    revisions.add(Revision.fromString(mk.commit("/","^\"foo/prop\":" + revisions.size(),null,null)));
  }
  mk.runBackgroundOperations();
  doc=store.find(NODES,Utils.getIdFromPath("/foo"));
  assertNotNull(doc);
  Map<Revision,String> localRevs=doc.getLocalRevisions();
  assertEquals(1,localRevs.size());
  for (  Revision rev : revisions) {
    assertTrue(doc.isCommitted(rev));
  }
  Map<Revision,String> valueMap=doc.getValueMap("prop");
  assertEquals((long)revisions.size(),valueMap.size());
  valueMap=doc.getLocalMap("prop");
  assertEquals(1L,valueMap.size());
}
