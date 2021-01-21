@Test public void costEstimation() throws Exception {
  NodeState root=INITIAL_CONTENT;
  NodeBuilder builder=root.builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"foo",true,false,ImmutableSet.of("foo"),null);
  NodeState before=builder.getNodeState();
  for (int i=0; i < MANY; i++) {
    builder.child("n" + i).setProperty("foo","x" + i % 20);
  }
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  FilterImpl f=createFilter(indexed,NT_BASE);
  PropertyIndexLookup lookup=new PropertyIndexLookup(indexed);
  double cost;
  cost=lookup.getCost(f,"foo",PropertyValues.newString("x1"));
  assertTrue("cost: " + cost,cost >= 6.5 && cost <= 7.5);
  cost=lookup.getCost(f,"foo",PropertyValues.newString(Arrays.asList("x1","x2")));
  assertTrue("cost: " + cost,cost >= 11.5 && cost <= 12.5);
  cost=lookup.getCost(f,"foo",PropertyValues.newString(Arrays.asList("x1","x2","x3","x4","x5")));
  assertTrue("cost: " + cost,cost >= 26.5 && cost <= 27.5);
  cost=lookup.getCost(f,"foo",PropertyValues.newString(Arrays.asList("x1","x2","x3","x4","x5","x6","x7","x8","x9","x0")));
  assertTrue("cost: " + cost,cost >= 51.5 && cost <= 52.5);
  cost=lookup.getCost(f,"foo",null);
  assertTrue("cost: " + cost,cost >= MANY);
}
