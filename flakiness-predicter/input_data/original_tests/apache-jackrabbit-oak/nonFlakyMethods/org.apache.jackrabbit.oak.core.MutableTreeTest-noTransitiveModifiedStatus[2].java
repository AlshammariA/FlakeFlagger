@Test public void noTransitiveModifiedStatus() throws CommitFailedException {
  Tree tree=root.getTree("/");
  tree.addChild("one").addChild("two");
  root.commit();
  tree.getChild("one").getChild("two").addChild("three");
  assertEquals(Tree.Status.UNCHANGED,tree.getChild("one").getStatus());
  assertEquals(Tree.Status.MODIFIED,tree.getChild("one").getChild("two").getStatus());
}
