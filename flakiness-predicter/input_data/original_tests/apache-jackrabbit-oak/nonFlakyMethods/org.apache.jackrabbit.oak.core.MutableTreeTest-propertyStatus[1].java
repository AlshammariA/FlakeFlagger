@Test public void propertyStatus() throws CommitFailedException {
  Tree tree=root.getTree("/");
  tree.setProperty("new","value1");
  assertEquals(Tree.Status.NEW,tree.getPropertyStatus("new"));
  root.commit();
  assertEquals(Tree.Status.UNCHANGED,tree.getPropertyStatus("new"));
  tree.setProperty("new","value2");
  assertEquals(Tree.Status.MODIFIED,tree.getPropertyStatus("new"));
  root.commit();
  assertEquals(Tree.Status.UNCHANGED,tree.getPropertyStatus("new"));
  tree.removeProperty("new");
  assertNull(tree.getPropertyStatus("new"));
  root.commit();
  assertNull(tree.getPropertyStatus("new"));
  Tree x=root.getTree("/x");
  x.setProperty("y","value1");
  x.remove();
}
