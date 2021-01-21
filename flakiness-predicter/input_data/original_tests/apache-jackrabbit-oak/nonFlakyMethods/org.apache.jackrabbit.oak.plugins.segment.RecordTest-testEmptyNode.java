@Test public void testEmptyNode(){
  NodeState before=EMPTY_NODE;
  NodeState after=writer.writeNode(before);
  assertEquals(before,after);
}
