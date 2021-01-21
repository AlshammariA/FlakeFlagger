@Test public void testDeepNode(){
  NodeBuilder root=EMPTY_NODE.builder();
  NodeBuilder builder=root;
  for (int i=0; i < 1000; i++) {
    builder=builder.child("test");
  }
  NodeState before=builder.getNodeState();
  NodeState after=writer.writeNode(before);
  assertEquals(before,after);
}
