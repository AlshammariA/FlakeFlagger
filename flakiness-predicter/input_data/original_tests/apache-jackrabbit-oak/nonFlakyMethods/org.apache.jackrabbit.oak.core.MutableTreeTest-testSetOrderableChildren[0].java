@Test public void testSetOrderableChildren() throws Exception {
  Tree tree=root.getTree("/").addChild("test2");
  tree.setOrderableChildren(true);
  String[] childNames=new String[]{"a","b","c","d"};
  for (  String name : childNames) {
    tree.addChild(name);
  }
  int index=0;
  for (  Tree child : tree.getChildren()) {
    assertEquals(childNames[index++],child.getName());
  }
}
