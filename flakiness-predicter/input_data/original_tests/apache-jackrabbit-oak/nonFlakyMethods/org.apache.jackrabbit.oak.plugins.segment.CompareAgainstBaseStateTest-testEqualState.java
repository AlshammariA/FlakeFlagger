@Test public void testEqualState(){
  NodeState before=builder.getNodeState();
  NodeState after=before.builder().getNodeState();
  replay(diff);
  after.compareAgainstBaseState(before,diff);
  verify(diff);
}
