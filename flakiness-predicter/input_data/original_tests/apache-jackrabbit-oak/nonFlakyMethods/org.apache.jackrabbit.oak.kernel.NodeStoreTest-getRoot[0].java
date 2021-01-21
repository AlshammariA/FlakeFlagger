@Test public void getRoot(){
  assertEquals(root,store.getRoot());
  assertEquals(root.getChildNode("test"),store.getRoot().getChildNode("test"));
  assertEquals(root.getChildNode("test").getChildNode("x"),store.getRoot().getChildNode("test").getChildNode("x"));
  assertEquals(root.getChildNode("test").getChildNode("any"),store.getRoot().getChildNode("test").getChildNode("any"));
  assertEquals(root.getChildNode("test").getProperty("a"),store.getRoot().getChildNode("test").getProperty("a"));
  assertEquals(root.getChildNode("test").getProperty("any"),store.getRoot().getChildNode("test").getProperty("any"));
}
