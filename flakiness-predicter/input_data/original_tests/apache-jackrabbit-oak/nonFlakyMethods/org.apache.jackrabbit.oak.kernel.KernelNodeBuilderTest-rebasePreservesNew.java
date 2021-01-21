@Test public void rebasePreservesNew(){
  NodeStore store=createNodeStore();
  NodeBuilder root=store.getRoot().builder();
  NodeBuilder added=root.setChildNode("added");
  assertTrue(root.hasChildNode("added"));
  assertTrue(added.isNew());
  store.rebase(root);
  assertTrue(added.exists());
  assertTrue(root.hasChildNode("added"));
  assertTrue(added.isNew());
}
