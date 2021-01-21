/** 
 * Async Index Test with 2 index defs at the same location <ul> <li>Add an index definition</li> <li>Add some content</li> <li>Search & verify</li> </ul>
 */
@Test public void testAsyncDouble() throws Exception {
  NodeStore store=new MemoryNodeStore();
  IndexEditorProvider provider=new PropertyIndexEditorProvider();
  NodeBuilder builder=store.getRoot().builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null).setProperty(ASYNC_PROPERTY_NAME,"async");
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndexSecond",true,false,ImmutableSet.of("bar"),null).setProperty(ASYNC_PROPERTY_NAME,"async");
  builder.child("testRoot").setProperty("foo","abc").setProperty("bar","def");
  builder.child("testSecond").setProperty("bar","ghi");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  NodeState root=store.getRoot();
  checkPathExists(root,INDEX_DEFINITIONS_NAME,"rootIndex",INDEX_CONTENT_NODE_NAME);
  checkPathExists(root,INDEX_DEFINITIONS_NAME,"rootIndexSecond",INDEX_CONTENT_NODE_NAME);
  PropertyIndexLookup lookup=new PropertyIndexLookup(root);
  assertEquals(ImmutableSet.of("testRoot"),find(lookup,"foo","abc"));
  assertEquals(ImmutableSet.<String>of(),find(lookup,"foo","def"));
  assertEquals(ImmutableSet.<String>of(),find(lookup,"foo","ghi"));
  assertEquals(ImmutableSet.<String>of(),find(lookup,"bar","abc"));
  assertEquals(ImmutableSet.of("testRoot"),find(lookup,"bar","def"));
  assertEquals(ImmutableSet.of("testSecond"),find(lookup,"bar","ghi"));
}
