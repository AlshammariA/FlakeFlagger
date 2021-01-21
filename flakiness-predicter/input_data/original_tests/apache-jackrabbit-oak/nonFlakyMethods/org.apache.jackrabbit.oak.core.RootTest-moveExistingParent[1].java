@Test public void moveExistingParent() throws CommitFailedException {
  Root root=session.getLatestRoot();
  root.getTree("/").addChild("parent").addChild("new");
  root.commit();
  Tree parent=root.getTree("/parent");
  Tree n=root.getTree("/parent/new");
  root.move("/parent","/moved");
  assertEquals(Status.NEW,parent.getStatus());
  assertEquals(Status.NEW,n.getStatus());
  assertEquals("/moved",parent.getPath());
  assertEquals("/moved/new",n.getPath());
}
