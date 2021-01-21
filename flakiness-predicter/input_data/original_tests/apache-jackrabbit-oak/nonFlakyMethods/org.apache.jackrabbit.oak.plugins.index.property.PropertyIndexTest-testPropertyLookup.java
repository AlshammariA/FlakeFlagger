@Test public void testPropertyLookup() throws Exception {
  NodeState root=INITIAL_CONTENT;
  NodeBuilder builder=root.builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"foo",true,false,ImmutableSet.of("foo"),null);
  NodeState before=builder.getNodeState();
  builder.child("a").setProperty("foo","abc");
  builder.child("b").setProperty("foo",Arrays.asList("abc","def"),Type.STRINGS);
  for (int i=0; i < MANY; i++) {
    builder.child("n" + i).setProperty("foo","xyz");
  }
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  FilterImpl f=createFilter(indexed,NT_BASE);
  PropertyIndexLookup lookup=new PropertyIndexLookup(indexed);
  assertEquals(ImmutableSet.of("a","b"),find(lookup,"foo","abc",f));
  assertEquals(ImmutableSet.of("b"),find(lookup,"foo","def",f));
  assertEquals(ImmutableSet.of(),find(lookup,"foo","ghi",f));
  assertEquals(MANY,find(lookup,"foo","xyz",f).size());
  assertEquals(MANY + 2,find(lookup,"foo",null,f).size());
  double cost;
  cost=lookup.getCost(f,"foo",PropertyValues.newString("xyz"));
  assertTrue("cost: " + cost,cost >= MANY);
  cost=lookup.getCost(f,"foo",null);
  assertTrue("cost: " + cost,cost >= MANY);
}
