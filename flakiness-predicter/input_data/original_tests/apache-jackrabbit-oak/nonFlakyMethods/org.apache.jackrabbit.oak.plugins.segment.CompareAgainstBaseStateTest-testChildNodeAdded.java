@Test public void testChildNodeAdded(){
  NodeState before=builder.getNodeState();
  builder=before.builder();
  builder.child("test");
  NodeState after=builder.getNodeState();
  expect(diff.childNodeAdded("test",after.getChildNode("test"))).andReturn(true);
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
