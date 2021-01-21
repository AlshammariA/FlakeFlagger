@Test public void rebaseWithMove() throws CommitFailedException {
  Root root1=session.getLatestRoot();
  Root root2=session.getLatestRoot();
  checkEqual(root1.getTree("/"),root2.getTree("/"));
  root2.getTree("/").addChild("one").addChild("two").addChild("three").setProperty("p1","V1");
  root2.commit();
  root1.move("/x","/y/x-moved");
  root1.rebase();
  root2.move("/x","/y/x-moved");
  checkEqual(root1.getTree("/"),(root2.getTree("/")));
}
