@Test public void testIndexDefinitions() throws Exception {
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"existing",true,false,ImmutableSet.of("foo"),null);
  NodeState before=builder.getNodeState();
  NodeBuilder other=builder.child("test").child("other");
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"foo",true,false,ImmutableSet.of("foo"),null);
  createIndexDefinition(other.child(INDEX_DEFINITIONS_NAME),"index2",true,false,ImmutableSet.of("foo"),null);
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  checkPathExists(indexed,INDEX_DEFINITIONS_NAME,"existing",INDEX_CONTENT_NODE_NAME);
  checkPathExists(indexed,"test","other",INDEX_DEFINITIONS_NAME,"index2",INDEX_CONTENT_NODE_NAME);
}
