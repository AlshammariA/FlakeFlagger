@Test public void move() throws CommitFailedException {
  Root root=session.getLatestRoot();
  Tree tree=root.getTree("/");
  Tree y=tree.getChild("y");
  Tree x=tree.getChild("x");
  assertTrue(x.exists());
  assertFalse(root.hasPendingChanges());
  root.move("/x","/y/xx");
  assertTrue(root.hasPendingChanges());
  assertFalse(tree.hasChild("x"));
  assertTrue(y.hasChild("xx"));
  assertEquals("/y/xx",x.getPath());
  root.commit();
  assertFalse(root.hasPendingChanges());
  assertFalse(tree.hasChild("x"));
  assertTrue(tree.hasChild("y"));
  assertTrue(tree.getChild("y").hasChild("xx"));
}
