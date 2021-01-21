@Test public void rename() throws CommitFailedException {
  Root root=session.getLatestRoot();
  Tree tree=root.getTree("/");
  Tree x=tree.getChild("x");
  assertTrue(x.exists());
  root.move("/x","/xx");
  assertFalse(tree.hasChild("x"));
  assertTrue(tree.hasChild("xx"));
  assertEquals("/xx",x.getPath());
  root.commit();
  assertFalse(tree.hasChild("x"));
  assertTrue(tree.hasChild("xx"));
}
