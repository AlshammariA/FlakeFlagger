@Test public void transitiveRemove(){
  NodeBuilder root=base.builder();
  NodeBuilder x=root.getChildNode("x");
  NodeBuilder q=x.getChildNode("q");
  assertTrue(x.exists());
  assertTrue(q.exists());
  root.getChildNode("x").remove();
  assertFalse(q.exists());
  assertFalse(x.exists());
}
