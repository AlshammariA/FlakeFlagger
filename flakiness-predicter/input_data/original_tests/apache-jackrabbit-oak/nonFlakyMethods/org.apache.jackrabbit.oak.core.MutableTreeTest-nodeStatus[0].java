@Test public void nodeStatus() throws CommitFailedException {
  Tree tree=root.getTree("/");
  tree.addChild("new");
  assertEquals(Tree.Status.NEW,tree.getChild("new").getStatus());
  root.commit();
  assertEquals(Tree.Status.UNCHANGED,tree.getChild("new").getStatus());
  Tree added=tree.getChild("new");
  added.addChild("another");
  assertEquals(Tree.Status.MODIFIED,tree.getChild("new").getStatus());
  root.commit();
  assertEquals(Tree.Status.UNCHANGED,tree.getChild("new").getStatus());
  tree.getChild("new").getChild("another").remove();
  assertEquals(Tree.Status.MODIFIED,tree.getChild("new").getStatus());
  root.commit();
  assertEquals(Tree.Status.UNCHANGED,tree.getChild("new").getStatus());
  assertFalse(tree.getChild("new").getChild("another").exists());
  Tree x=root.getTree("/x");
  Tree y=x.addChild("y");
  x.remove();
  assertFalse(x.exists());
  assertFalse(y.exists());
}
