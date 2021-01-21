@Test public void rebaseWithAddProperty() throws CommitFailedException {
  Root root1=session.getLatestRoot();
  Root root2=session.getLatestRoot();
  checkEqual(root1.getTree("/"),root2.getTree("/"));
  root2.getTree("/").addChild("one").addChild("two").addChild("three").setProperty("p1","V1");
  root2.commit();
  root1.getTree("/").setProperty("new",42);
  root1.rebase();
  root2.getTree("/").setProperty("new",42);
  checkEqual(root1.getTree("/"),(root2.getTree("/")));
}
