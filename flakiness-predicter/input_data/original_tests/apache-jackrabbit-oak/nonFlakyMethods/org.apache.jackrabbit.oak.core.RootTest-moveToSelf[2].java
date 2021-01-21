@Test public void moveToSelf() throws CommitFailedException {
  Root root=session.getLatestRoot();
  root.getTree("/").addChild("s");
  root.commit();
  assertTrue(root.move("/s","/s"));
}
