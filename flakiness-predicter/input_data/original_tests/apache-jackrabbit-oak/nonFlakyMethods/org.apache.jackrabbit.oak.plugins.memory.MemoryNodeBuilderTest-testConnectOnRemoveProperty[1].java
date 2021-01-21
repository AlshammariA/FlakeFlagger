@Test public void testConnectOnRemoveProperty(){
  NodeBuilder root=base.builder();
  NodeBuilder childA=root.child("x");
  NodeBuilder childB=root.child("x");
  childB.setProperty("test","foo");
  childA.removeProperty("test");
  assertFalse(childA.hasProperty("test"));
  assertFalse(childB.hasProperty("test"));
  childA.setProperty("test","bar");
  assertEquals("bar",childA.getProperty("test").getValue(STRING));
  assertEquals("bar",childB.getProperty("test").getValue(STRING));
}
