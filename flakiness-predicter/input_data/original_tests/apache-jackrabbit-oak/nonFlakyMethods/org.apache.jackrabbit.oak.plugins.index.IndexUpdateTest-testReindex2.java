/** 
 * Reindex Test <ul> <li>Add some content & an index definition</li> <li>Update the index def by setting the reindex flag to true</li> <li>Search & verify</li> </ul>
 */
@Test public void testReindex2() throws Exception {
  builder.child("testRoot").setProperty("foo","abc");
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null).removeProperty("reindex");
  NodeState before=builder.getNodeState();
  builder.child(INDEX_DEFINITIONS_NAME).child("rootIndex").setProperty(REINDEX_PROPERTY_NAME,true);
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  NodeState ns=checkPathExists(indexed,INDEX_DEFINITIONS_NAME,"rootIndex");
  checkPathExists(ns,INDEX_CONTENT_NODE_NAME);
  PropertyState ps=ns.getProperty(REINDEX_PROPERTY_NAME);
  assertNotNull(ps);
  assertFalse(ps.getValue(Type.BOOLEAN));
  PropertyIndexLookup lookup=new PropertyIndexLookup(indexed);
  assertEquals(ImmutableSet.of("testRoot"),find(lookup,"foo","abc"));
}
