@Test public void testUnmodifiedEqualsBase(){
  NodeBuilder root=base.builder();
  NodeBuilder x=root.child("x");
  assertEquals(x.getBaseState(),x.getNodeState());
}
