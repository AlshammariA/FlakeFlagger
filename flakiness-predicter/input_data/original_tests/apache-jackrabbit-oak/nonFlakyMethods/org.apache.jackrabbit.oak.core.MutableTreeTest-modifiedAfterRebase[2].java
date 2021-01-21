@Test public void modifiedAfterRebase() throws CommitFailedException {
  Tree tree=root.getTree("/");
  tree.addChild("new");
  assertEquals(Status.MODIFIED,tree.getStatus());
  root.rebase();
  assertEquals(Status.MODIFIED,tree.getStatus());
}
