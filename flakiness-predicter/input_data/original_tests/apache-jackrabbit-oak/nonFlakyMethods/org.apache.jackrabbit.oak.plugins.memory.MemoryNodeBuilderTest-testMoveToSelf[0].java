@Test public void testMoveToSelf(){
  NodeBuilder rootBuilder=base.builder();
  assertFalse(rootBuilder.getChildNode("y").moveTo(rootBuilder,"y"));
  NodeState newRoot=rootBuilder.getNodeState();
  assertTrue(newRoot.hasChildNode("y"));
}
