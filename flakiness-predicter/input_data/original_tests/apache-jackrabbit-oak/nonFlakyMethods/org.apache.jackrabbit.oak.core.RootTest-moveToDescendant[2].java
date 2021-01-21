@Test public void moveToDescendant() throws CommitFailedException {
  Root root=session.getLatestRoot();
  root.getTree("/").addChild("s");
  root.commit();
  assertFalse(root.move("/s","/s/t"));
}
