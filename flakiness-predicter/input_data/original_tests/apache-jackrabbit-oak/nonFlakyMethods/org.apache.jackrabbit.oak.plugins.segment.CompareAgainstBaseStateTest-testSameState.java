@Test public void testSameState(){
  NodeState node=builder.getNodeState();
  replay(diff);
  node.compareAgainstBaseState(node,diff);
  verify(diff);
}
