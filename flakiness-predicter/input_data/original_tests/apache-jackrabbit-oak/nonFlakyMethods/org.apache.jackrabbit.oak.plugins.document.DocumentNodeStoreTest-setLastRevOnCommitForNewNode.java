@Test public void setLastRevOnCommitForNewNode() throws Exception {
  DocumentNodeStore ns=new DocumentMK.Builder().setAsyncDelay(0).getNodeStore();
  NodeBuilder builder=ns.getRoot().builder();
  builder.child("foo");
  ns.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  builder=ns.getRoot().builder();
  builder.child("bar");
  ns.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  NodeDocument doc=ns.getDocumentStore().find(NODES,Utils.getIdFromPath("/bar"));
  assertEquals(1,doc.getLastRev().size());
  ns.dispose();
}
