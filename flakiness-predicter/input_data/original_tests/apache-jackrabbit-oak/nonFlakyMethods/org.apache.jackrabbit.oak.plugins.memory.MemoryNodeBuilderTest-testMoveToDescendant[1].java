@Test public void testMoveToDescendant(){
  NodeBuilder rootBuilder=base.builder();
  assertTrue(rootBuilder.getChildNode("x").moveTo(rootBuilder.getChildNode("x"),"xx"));
  assertFalse(rootBuilder.hasChildNode("x"));
}
