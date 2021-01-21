@Test public void rebase() throws CommitFailedException {
  Root root1=session.getLatestRoot();
  Root root2=session.getLatestRoot();
  checkEqual(root1.getTree("/"),root2.getTree("/"));
  root2.getTree("/").addChild("one").addChild("two").addChild("three").setProperty("p1","V1");
  root2.commit();
  root1.rebase();
  checkEqual(root1.getTree("/"),(root2.getTree("/")));
  Tree one=root2.getTree("/one");
  one.getChild("two").remove();
  one.addChild("four");
  root2.commit();
  root1.rebase();
  checkEqual(root1.getTree("/"),(root2.getTree("/")));
}
