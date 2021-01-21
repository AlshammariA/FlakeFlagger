@Test public void isNew() throws CommitFailedException {
  Tree tree=root.getTree("/");
  tree.addChild("c");
  root.commit();
  tree.getChild("c").remove();
  Tree c=tree.addChild("c");
  assertEquals(Status.NEW,c.getStatus());
}
