@Test public void testChildNodeChanged(){
  NodeState before=builder.getNodeState();
  builder.child("baz").setProperty("test","test");
  NodeState after=builder.getNodeState();
  expect(diff.childNodeChanged("baz",before.getChildNode("baz"),after.getChildNode("baz"))).andReturn(true);
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
