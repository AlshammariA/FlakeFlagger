@Test public void removeNew(){
  Tree tree=root.getTree("/");
  Tree t=tree.addChild("new");
  tree.getChild("new").remove();
  assertFalse(t.exists());
  assertFalse(tree.getChild("new").exists());
}
