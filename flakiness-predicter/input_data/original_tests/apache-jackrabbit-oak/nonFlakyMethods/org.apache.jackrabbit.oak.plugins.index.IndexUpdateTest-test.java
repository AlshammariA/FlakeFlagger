/** 
 * Simple Test <ul> <li>Add an index definition</li> <li>Add some content</li> <li>Search & verify</li> </ul>
 */
@Test public void test() throws Exception {
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null);
  createIndexDefinition(builder.child("newchild").child("other").child(INDEX_DEFINITIONS_NAME),"subIndex",true,false,ImmutableSet.of("foo"),null);
  NodeState before=builder.getNodeState();
  builder.child("testRoot").setProperty("foo","abc");
  builder.child("newchild").child("other").child("testChild").setProperty("foo","xyz");
  NodeState after=builder.getNodeState();
  NodeState indexed=HOOK.processCommit(before,after,CommitInfo.EMPTY);
  checkPathExists(indexed,INDEX_DEFINITIONS_NAME,"rootIndex",INDEX_CONTENT_NODE_NAME);
  checkPathExists(indexed,"newchild","other",INDEX_DEFINITIONS_NAME,"subIndex",INDEX_CONTENT_NODE_NAME);
  PropertyIndexLookup lookup=new PropertyIndexLookup(indexed);
  assertEquals(ImmutableSet.of("testRoot"),find(lookup,"foo","abc"));
  PropertyIndexLookup lookupChild=new PropertyIndexLookup(indexed.getChildNode("newchild").getChildNode("other"));
  assertEquals(ImmutableSet.of("testChild"),find(lookupChild,"foo","xyz"));
  assertEquals(ImmutableSet.of(),find(lookupChild,"foo","abc"));
}
