@Test public void rebaseInvariant(){
  NodeStore store=createNodeStore();
  NodeBuilder root=store.getRoot().builder();
  NodeBuilder added=root.setChildNode("added");
  NodeState base=root.getBaseState();
  store.rebase(root);
  assertEquals(base,root.getBaseState());
}
