@Test public void merge() throws CommitFailedException {
  NodeState base=store.getRoot();
  NodeBuilder builder1=base.builder();
  NodeBuilder builder2=base.builder();
  builder1.setChildNode("node1");
  builder2.setChildNode("node2");
  store.merge(builder1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue(store.getRoot().hasChildNode("node1"));
  assertFalse(store.getRoot().hasChildNode("node2"));
  store.merge(builder2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue(store.getRoot().hasChildNode("node1"));
  assertTrue(store.getRoot().hasChildNode("node2"));
}
