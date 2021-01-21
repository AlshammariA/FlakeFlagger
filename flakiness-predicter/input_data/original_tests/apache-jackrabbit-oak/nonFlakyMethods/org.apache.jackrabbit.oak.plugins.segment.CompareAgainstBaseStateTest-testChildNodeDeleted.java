@Test public void testChildNodeDeleted(){
  NodeState before=builder.getNodeState();
  builder.getChildNode("baz").remove();
  NodeState after=builder.getNodeState();
  expect(diff.childNodeDeleted("baz",before.getChildNode("baz"))).andReturn(true);
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
