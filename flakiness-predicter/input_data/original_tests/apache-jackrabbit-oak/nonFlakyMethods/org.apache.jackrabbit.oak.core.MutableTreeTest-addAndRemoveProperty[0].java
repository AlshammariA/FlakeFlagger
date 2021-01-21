@Test public void addAndRemoveProperty() throws CommitFailedException {
  Tree tree=root.getTree("/");
  tree.setProperty("P0","V1");
  root.commit();
  assertTrue(tree.hasProperty("P0"));
  tree.removeProperty("P0");
  root.commit();
  assertFalse(tree.hasProperty("P0"));
}
