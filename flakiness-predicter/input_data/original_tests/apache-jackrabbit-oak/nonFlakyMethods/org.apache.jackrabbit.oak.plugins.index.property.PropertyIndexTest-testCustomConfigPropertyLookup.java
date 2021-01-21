@Test public void testCustomConfigPropertyLookup() throws Exception {
  NodeState root=INITIAL_CONTENT;
  NodeBuilder builder=root.builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"fooIndex",true,false,ImmutableSet.of("foo","extrafoo"),null);
  NodeState before=builder.getNodeState();
  builder.child("a").setProperty("foo","abc").setProperty("extrafoo","pqr");
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
  assertEquals(ImmutableSet.of("a"),find(lookup,"extrafoo","pqr",f));
  try {
    assertEquals(ImmutableSet.of(),find(lookup,"pqr","foo",f));
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
}
