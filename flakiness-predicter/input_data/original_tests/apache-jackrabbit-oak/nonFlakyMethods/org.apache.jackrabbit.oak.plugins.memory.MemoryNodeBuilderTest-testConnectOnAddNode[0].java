@Test public void testConnectOnAddNode(){
  NodeBuilder root=base.builder();
  NodeBuilder childA=root.child("x");
  NodeBuilder childB=root.child("x");
  assertFalse(childA.hasChildNode("test"));
  assertFalse(childB.hasChildNode("test"));
  childB.child("test");
  assertTrue(childA.hasChildNode("test"));
  assertTrue(childB.hasChildNode("test"));
}
