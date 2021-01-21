/** 
 * Async Index Test with 2 index defs at different tree locations <ul> <li>Add an index definition</li> <li>Add some content</li> <li>Search & verify</li> </ul>
 */
@Test public void testAsyncDoubleSubtree() throws Exception {
  NodeStore store=new MemoryNodeStore();
  IndexEditorProvider provider=new PropertyIndexEditorProvider();
  NodeBuilder builder=store.getRoot().builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null).setProperty(ASYNC_PROPERTY_NAME,"async");
  createIndexDefinition(builder.child("newchild").child("other").child(INDEX_DEFINITIONS_NAME),"subIndex",true,false,ImmutableSet.of("foo"),null).setProperty(ASYNC_PROPERTY_NAME,"async");
  builder.child("testRoot").setProperty("foo","abc");
  builder.child("newchild").child("other").child("testChild").setProperty("foo","xyz");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  NodeState root=store.getRoot();
  checkPathExists(root,INDEX_DEFINITIONS_NAME,"rootIndex",INDEX_CONTENT_NODE_NAME);
  checkPathExists(root,"newchild","other",INDEX_DEFINITIONS_NAME,"subIndex",INDEX_CONTENT_NODE_NAME);
  PropertyIndexLookup lookup=new PropertyIndexLookup(root);
  assertEquals(ImmutableSet.of("testRoot"),find(lookup,"foo","abc"));
  PropertyIndexLookup lookupChild=new PropertyIndexLookup(root.getChildNode("newchild").getChildNode("other"));
  assertEquals(ImmutableSet.of("testChild"),find(lookupChild,"foo","xyz"));
  assertEquals(ImmutableSet.<String>of(),find(lookupChild,"foo","abc"));
}
