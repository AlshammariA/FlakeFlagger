@Test public void testPropertyAdded(){
  NodeState before=builder.getNodeState();
  builder=before.builder();
  builder.setProperty("test","test");
  NodeState after=builder.getNodeState();
  expect(diff.propertyAdded(after.getProperty("test"))).andReturn(true);
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
