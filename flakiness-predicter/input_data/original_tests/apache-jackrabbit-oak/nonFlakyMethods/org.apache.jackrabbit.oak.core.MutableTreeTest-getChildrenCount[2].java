@Test public void getChildrenCount(){
  Tree tree=root.getTree("/");
  assertEquals(3,tree.getChildrenCount(4));
  tree.getChild("x").remove();
  assertEquals(2,tree.getChildrenCount(3));
  tree.addChild("a");
  assertEquals(3,tree.getChildrenCount(3));
  tree.addChild("x");
  assertEquals(4,tree.getChildrenCount(5));
}
