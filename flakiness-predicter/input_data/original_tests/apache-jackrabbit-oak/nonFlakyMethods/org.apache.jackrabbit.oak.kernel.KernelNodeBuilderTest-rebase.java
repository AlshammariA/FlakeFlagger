@Test public void rebase() throws CommitFailedException {
  NodeStore store=createNodeStore();
  NodeBuilder root=store.getRoot().builder();
  modify(store);
  store.rebase(root);
  assertEquals(store.getRoot(),root.getBaseState());
}
