@Test public void commitRootInPrevious(){
  DocumentStore store=mk.getDocumentStore();
  DocumentNodeStore ns=mk.getNodeStore();
  mk.commit("/","+\"test\":{\"node\":{}}",null,null);
  mk.commit("/test","+\"foo\":{}+\"bar\":{}",null,null);
  mk.commit("/test","^\"foo/prop\":0^\"bar/prop\":0",null,null);
  NodeDocument doc=store.find(NODES,Utils.getIdFromPath("/test/foo"));
  assertNotNull(doc);
  String rev=null;
  for (int i=0; i < NodeDocument.NUM_REVS_THRESHOLD; i++) {
    rev=mk.commit("/test/foo","^\"prop\":" + i,null,null);
  }
  ns.runBackgroundOperations();
  doc=store.find(NODES,Utils.getIdFromPath("/test/foo"));
  assertNotNull(doc);
  DocumentNodeState node=doc.getNodeAtRevision(ns,Revision.fromString(rev),null);
  assertNotNull(node);
}
