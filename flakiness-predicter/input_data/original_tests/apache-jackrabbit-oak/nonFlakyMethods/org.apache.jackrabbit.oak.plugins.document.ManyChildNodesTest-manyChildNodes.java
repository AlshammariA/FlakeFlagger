@Test public void manyChildNodes() throws Exception {
  TestStore store=new TestStore();
  DocumentMK mk=new DocumentMK.Builder().setDocumentStore(store).open();
  NodeStore ns=mk.getNodeStore();
  NodeBuilder builder=ns.getRoot().builder();
  for (int i=0; i < DocumentNodeState.MAX_FETCH_SIZE * 2; i++) {
    builder.child("c-" + i);
  }
  ns.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  store.queries.clear();
  for (  ChildNodeEntry entry : ns.getRoot().getChildNodeEntries()) {
    entry.getName();
  }
  int maxFetchSize=DocumentNodeState.MAX_FETCH_SIZE + 1;
  for (  Map.Entry<String,Integer> e : store.queries.entrySet()) {
    assertTrue(e.getValue() + " > " + maxFetchSize,e.getValue() <= maxFetchSize);
  }
  mk.dispose();
}
