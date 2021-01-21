@Test public void testPropertyDeleted(){
  NodeState before=builder.getNodeState();
  builder=before.builder();
  builder.removeProperty("foo");
  NodeState after=builder.getNodeState();
  expect(diff.propertyDeleted(before.getProperty("foo"))).andReturn(true);
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
