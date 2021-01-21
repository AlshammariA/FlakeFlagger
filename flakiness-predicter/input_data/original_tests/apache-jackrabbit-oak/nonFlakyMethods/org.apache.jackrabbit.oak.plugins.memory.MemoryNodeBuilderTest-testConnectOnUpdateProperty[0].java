@Test public void testConnectOnUpdateProperty(){
  NodeBuilder root=base.builder();
  NodeBuilder childA=root.child("x");
  NodeBuilder childB=root.child("x");
  childB.setProperty("test","foo");
  childA.setProperty("test","bar");
  assertEquals("bar",childA.getProperty("test").getValue(STRING));
  assertEquals("bar",childB.getProperty("test").getValue(STRING));
}
