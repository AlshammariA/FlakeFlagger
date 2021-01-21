@Test public void splitCommitRoot() throws Exception {
  DocumentStore store=mk.getDocumentStore();
  mk.commit("/","+\"foo\":{}+\"bar\":{}",null,null);
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/foo"));
  assertNotNull(doc);
  Set<Revision> commitRoots=Sets.newHashSet();
  commitRoots.addAll(doc.getLocalCommitRoot().keySet());
  while (commitRoots.size() <= NodeDocument.NUM_REVS_THRESHOLD) {
    commitRoots.add(Revision.fromString(mk.commit("/","^\"foo/prop\":" + commitRoots.size() + "^\"bar/prop\":"+ commitRoots.size(),null,null)));
  }
  mk.runBackgroundOperations();
  doc=store.find(NODES,Utils.getIdFromPath("/foo"));
  assertNotNull(doc);
  Map<Revision,String> commits=doc.getLocalCommitRoot();
  assertEquals(1,commits.size());
  for (  Revision rev : commitRoots) {
    assertTrue(doc.isCommitted(rev));
  }
}
