@Test public void addExistingChild() throws CommitFailedException {
  Tree tree=root.getTree("/");
  assertFalse(tree.hasChild("new"));
  tree.addChild("new");
  root.commit();
  assertTrue(tree.hasChild("new"));
  Tree added=tree.addChild("new");
  assertTrue(added.exists());
  assertEquals("new",added.getName());
}
