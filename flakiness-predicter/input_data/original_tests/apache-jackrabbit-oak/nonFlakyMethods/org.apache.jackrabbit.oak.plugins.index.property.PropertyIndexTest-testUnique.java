@Test(expected=CommitFailedException.class) public void testUnique() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"fooIndex",true,true,ImmutableSet.of("foo"),null);
  NodeState before=builder.getNodeState();
  builder.child("a").setProperty("foo","abc");
  builder.child("b").setProperty("foo",Arrays.asList("abc","def"),Type.STRINGS);
  NodeState after=builder.getNodeState();
  HOOK.processCommit(before,after,CommitInfo.EMPTY);
}
