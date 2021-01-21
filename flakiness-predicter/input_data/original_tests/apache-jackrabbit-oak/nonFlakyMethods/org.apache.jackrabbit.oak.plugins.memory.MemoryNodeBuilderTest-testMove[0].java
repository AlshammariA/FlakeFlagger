@Test public void testMove(){
  NodeBuilder rootBuilder=base.builder();
  assertTrue(rootBuilder.getChildNode("y").moveTo(rootBuilder.child("x"),"yy"));
  NodeState newRoot=rootBuilder.getNodeState();
  assertFalse(newRoot.hasChildNode("y"));
  assertTrue(newRoot.hasChildNode("x"));
  assertTrue(newRoot.getChildNode("x").hasChildNode("q"));
  assertTrue(newRoot.getChildNode("x").hasChildNode("yy"));
}
