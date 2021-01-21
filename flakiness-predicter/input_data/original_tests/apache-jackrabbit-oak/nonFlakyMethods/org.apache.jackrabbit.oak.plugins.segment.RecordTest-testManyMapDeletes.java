@Test public void testManyMapDeletes(){
  NodeBuilder builder=EMPTY_NODE.builder();
  for (int i=0; i < 1000; i++) {
    builder.child("test" + i);
  }
  NodeState before=writer.writeNode(builder.getNodeState());
  assertEquals(builder.getNodeState(),before);
  builder=before.builder();
  for (int i=0; i < 900; i++) {
    builder.getChildNode("test" + i).remove();
  }
  NodeState after=writer.writeNode(builder.getNodeState());
  assertEquals(builder.getNodeState(),after);
}
