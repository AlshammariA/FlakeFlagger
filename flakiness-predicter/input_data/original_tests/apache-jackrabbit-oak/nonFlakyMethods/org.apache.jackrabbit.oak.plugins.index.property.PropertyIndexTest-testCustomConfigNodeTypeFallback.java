/** 
 * @see <a href="https://issues.apache.org/jira/browse/OAK-666">OAK-666:
     *      Property2Index: node type is used when indexing, but ignored when
     *      querying</a>
 */
@Test public void testCustomConfigNodeTypeFallback() throws Exception {
  NodeState root=EMPTY_NODE;
  NodeBuilder builder=root.builder();
  NodeBuilder index=builder.child(INDEX_DEFINITIONS_NAME);
  createIndexDefinition(index,"fooIndex",true,false,ImmutableSet.of("foo","extrafoo"),null);
  createIndexDefinition(index,"fooIndexFile",true,false,ImmutableSet.of("foo"),ImmutableSet.of(NT_FILE));
  NodeState before=builder.getNodeState();
  builder.child("a").setProperty(JCR_PRIMARYTYPE,NT_UNSTRUCTURED,Type.NAME).setProperty("foo","abc");
  builder.child("b").setProperty(JCR_PRIMARYTYPE,NT_UNSTRUCTURED,Type.NAME).setProperty("foo",Arrays.asList("abc","def"),Type.STRINGS);
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  FilterImpl f=createFilter(after,NT_UNSTRUCTURED);
  PropertyIndexLookup lookup=new PropertyIndexLookup(indexed);
  assertEquals(ImmutableSet.of("a","b"),find(lookup,"foo","abc",f));
  assertEquals(ImmutableSet.of("b"),find(lookup,"foo","def",f));
  assertEquals(ImmutableSet.of(),find(lookup,"foo","ghi",f));
  try {
    assertEquals(ImmutableSet.of(),find(lookup,"pqr","foo",f));
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
}
