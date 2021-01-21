@Test public void moveNew(){
  Root root=session.getLatestRoot();
  Tree tree=root.getTree("/");
  Tree t=tree.addChild("new");
  root.move("/new","/y/new");
  assertEquals("/y/new",t.getPath());
  assertFalse(tree.getChild("new").exists());
}
