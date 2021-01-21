@Test public void getPropertyCount(){
  Tree tree=root.getTree("/");
  assertEquals(3,tree.getPropertyCount());
  tree.setProperty("a","foo");
  assertEquals(3,tree.getPropertyCount());
  tree.removeProperty("a");
  assertEquals(2,tree.getPropertyCount());
  tree.setProperty("x","foo");
  assertEquals(3,tree.getPropertyCount());
  tree.setProperty("a","foo");
  assertEquals(4,tree.getPropertyCount());
}
