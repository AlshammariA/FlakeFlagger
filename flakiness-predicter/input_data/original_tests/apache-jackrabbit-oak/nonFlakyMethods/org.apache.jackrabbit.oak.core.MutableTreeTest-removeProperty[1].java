@Test public void removeProperty() throws CommitFailedException {
  Tree tree=root.getTree("/");
  assertTrue(tree.hasProperty("a"));
  tree.removeProperty("a");
  assertFalse(tree.hasProperty("a"));
  root.commit();
  assertFalse(tree.hasProperty("a"));
}
