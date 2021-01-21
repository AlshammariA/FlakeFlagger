@Test public void removeChild() throws CommitFailedException {
  Tree tree=root.getTree("/");
  assertTrue(tree.hasChild("x"));
  tree.getChild("x").remove();
  assertFalse(tree.hasChild("x"));
  root.commit();
  assertFalse(tree.hasChild("x"));
}
