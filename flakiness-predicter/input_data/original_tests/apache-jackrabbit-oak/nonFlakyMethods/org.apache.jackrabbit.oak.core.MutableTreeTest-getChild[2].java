@Test public void getChild(){
  Tree tree=root.getTree("/");
  Tree child=tree.getChild("any");
  assertFalse(child.exists());
  child=tree.getChild("x");
  assertTrue(child.exists());
}
