@Test public void addChild() throws CommitFailedException {
  Tree tree=root.getTree("/");
  assertFalse(tree.hasChild("new"));
  Tree added=tree.addChild("new");
  assertTrue(added.exists());
  assertEquals("new",added.getName());
  assertTrue(tree.hasChild("new"));
  root.commit();
  assertTrue(tree.hasChild("new"));
  tree.getChild("new").addChild("more");
  assertTrue(tree.getChild("new").hasChild("more"));
}
