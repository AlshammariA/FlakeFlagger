@Test public void testRename(){
  NodeBuilder rootBuilder=base.builder();
  assertTrue(rootBuilder.getChildNode("y").moveTo(rootBuilder,"yy"));
  NodeState newRoot=rootBuilder.getNodeState();
  assertFalse(newRoot.hasChildNode("y"));
  assertTrue(newRoot.hasChildNode("yy"));
}
