@Test public void oak962() throws CommitFailedException {
  Root root=session.getLatestRoot();
  Tree r=root.getTree("/").addChild("root");
  r.addChild("N3");
  r.addChild("N6");
  r.getChild("N6").addChild("N7");
  root.commit();
  root.move("/root/N6/N7","/root/N3/N12");
  r.getChild("N3").getChild("N12").remove();
  r.getChild("N6").remove();
  root.commit();
}
