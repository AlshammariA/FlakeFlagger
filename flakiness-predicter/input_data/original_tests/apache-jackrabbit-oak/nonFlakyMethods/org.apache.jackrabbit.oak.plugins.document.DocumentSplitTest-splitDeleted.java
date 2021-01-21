@Test public void splitDeleted() throws Exception {
  DocumentStore store=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  Set<Revision> revisions=Sets.newHashSet();
  mk.commit("/","+\"foo\":{}",null,null);
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/foo"));
  assertNotNull(doc);
  revisions.addAll(doc.getLocalRevisions().keySet());
  boolean create=false;
  while (revisions.size() <= NodeDocument.NUM_REVS_THRESHOLD) {
    if (create) {
      revisions.add(Revision.fromString(mk.commit("/","+\"foo\":{}",null,null)));
    }
 else {
      revisions.add(Revision.fromString(mk.commit("/","-\"foo\"",null,null)));
    }
    create=!create;
  }
  mk.runBackgroundOperations();
  String head=mk.getHeadRevision();
  doc=store.find(NODES,Utils.getIdFromPath("/foo"));
  assertNotNull(doc);
  Map<Revision,String> deleted=doc.getLocalDeleted();
  assertEquals(1,deleted.size());
  for (  Revision rev : revisions) {
    assertTrue("document should contain revision (or have revision in commit root path):" + rev,doc.containsRevision(rev) || doc.getCommitRootPath(rev) != null);
    assertTrue(doc.isCommitted(rev));
  }
  DocumentNodeState node=ns.getNode("/foo",Revision.fromString(head));
  if (create) {
    assertNull(node);
  }
 else {
    assertNotNull(node);
  }
}
