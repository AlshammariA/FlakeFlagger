/** 
 * Reindex Test <ul> <li>Add some content</li> <li>Add an index definition with the reindex flag set</li> <li>Search & verify</li> </ul>
 */
@Test public void testReindex() throws Exception {
  builder.child("testRoot").setProperty("foo","abc");
  NodeState before=builder.getNodeState();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null);
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
