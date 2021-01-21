@Test public void costMaxEstimation() throws Exception {
  NodeState root=EmptyNodeState.EMPTY_NODE;
  NodeBuilder builder=root.builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"foo",true,false,ImmutableSet.of("foo"),null);
  NodeState before=builder.getNodeState();
  int nodes=101;
  int levels=12;
  NodeBuilder data=builder;
  for (int i=0; i < levels; i++) {
    data=data.child("l" + i);
  }
  for (int i=0; i < nodes; i++) {
    NodeBuilder c=data.child("c_" + i);
    c.setProperty("foo","azerty");
  }
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  FilterImpl f=createFilter(indexed,NT_BASE);
  PropertyIndexLookup lookup=new PropertyIndexLookup(indexed);
  double cost=lookup.getCost(f,"foo",PropertyValues.newString("azerty"));
  double traversal=new TraversingIndex().getCost(f,indexed);
  assertTrue("Estimated cost for " + nodes + " nodes should not be higher than traversal ("+ cost+ ")",cost < traversal);
}
