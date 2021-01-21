@Test public void testReset2(){
  NodeBuilder root=base.builder();
  NodeBuilder x=root.child("x");
  x.child("y");
  ((MemoryNodeBuilder)root).reset(base);
  assertTrue(root.hasChildNode("x"));
  assertFalse(x.hasChildNode("y"));
}
