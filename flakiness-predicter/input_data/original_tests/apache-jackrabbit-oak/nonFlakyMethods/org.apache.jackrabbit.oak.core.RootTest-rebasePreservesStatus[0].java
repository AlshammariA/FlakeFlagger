@Test public void rebasePreservesStatus() throws CommitFailedException {
  Root root1=session.getLatestRoot();
  Root root2=session.getLatestRoot();
  Tree x=root1.getTree("/x");
  Tree added=x.addChild("added");
  assertEquals(NEW,added.getStatus());
  root2.getTree("/x").addChild("bar");
  root2.commit();
  root1.rebase();
  assertTrue(x.hasChild("added"));
  assertEquals(NEW,x.getChild("added").getStatus());
  assertTrue(x.hasChild("bar"));
}
