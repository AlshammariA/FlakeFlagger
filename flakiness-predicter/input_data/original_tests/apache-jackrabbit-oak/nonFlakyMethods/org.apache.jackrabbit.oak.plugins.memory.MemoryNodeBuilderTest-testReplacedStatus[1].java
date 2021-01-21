@Test public void testReplacedStatus(){
  NodeBuilder root=base.builder();
  NodeBuilder x=root.getChildNode("x");
  x.setChildNode("new");
  assertFalse(x.isReplaced());
}
