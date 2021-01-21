@Test public void testConnectOnAddProperty(){
  NodeBuilder root=base.builder();
  NodeBuilder childA=root.child("x");
  NodeBuilder childB=root.child("x");
  assertFalse(childA.hasProperty("test"));
  childB.setProperty("test","foo");
  assertTrue(childA.hasProperty("test"));
}
