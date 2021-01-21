@Test public void testSimpleNode(){
  NodeState before=EMPTY_NODE.builder().setProperty("foo","abc").setProperty("bar",123).setProperty("baz",Math.PI).getNodeState();
  NodeState after=writer.writeNode(before);
  assertEquals(before,after);
}
