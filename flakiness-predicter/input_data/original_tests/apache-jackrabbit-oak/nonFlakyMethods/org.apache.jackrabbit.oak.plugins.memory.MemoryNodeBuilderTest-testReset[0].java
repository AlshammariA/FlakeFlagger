@Test public void testReset(){
  NodeBuilder root=base.builder();
  NodeBuilder child=root.child("x");
  child.child("new");
  assertTrue(child.hasChildNode("new"));
  assertTrue(root.child("x").hasChildNode("new"));
  ((MemoryNodeBuilder)root).reset(base);
  assertFalse(child.hasChildNode("new"));
  assertFalse(root.child("x").hasChildNode("new"));
}
