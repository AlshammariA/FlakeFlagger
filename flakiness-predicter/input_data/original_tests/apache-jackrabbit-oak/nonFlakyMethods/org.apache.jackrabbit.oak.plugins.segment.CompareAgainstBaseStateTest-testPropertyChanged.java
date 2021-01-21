@Test public void testPropertyChanged(){
  NodeState before=builder.getNodeState();
  builder=before.builder();
  builder.setProperty("foo","test");
  NodeState after=builder.getNodeState();
  expect(diff.propertyChanged(before.getProperty("foo"),after.getProperty("foo"))).andReturn(true);
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
