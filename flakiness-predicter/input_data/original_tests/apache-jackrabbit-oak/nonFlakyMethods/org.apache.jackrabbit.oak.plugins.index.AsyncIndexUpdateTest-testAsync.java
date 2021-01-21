/** 
 * Async Index Test <ul> <li>Add an index definition</li> <li>Add some content</li> <li>Search & verify</li> </ul>
 */
@Test public void testAsync() throws Exception {
  NodeStore store=new MemoryNodeStore();
  IndexEditorProvider provider=new PropertyIndexEditorProvider();
  NodeBuilder builder=store.getRoot().builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null).setProperty(ASYNC_PROPERTY_NAME,"async");
  builder.child("testRoot").setProperty("foo","abc");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  NodeState root=store.getRoot();
  checkPathExists(root,INDEX_DEFINITIONS_NAME,"rootIndex",INDEX_CONTENT_NODE_NAME);
  assertFalse(root.getChildNode(INDEX_DEFINITIONS_NAME).hasChildNode(":conflict"));
  PropertyIndexLookup lookup=new PropertyIndexLookup(root);
  assertEquals(ImmutableSet.of("testRoot"),find(lookup,"foo","abc"));
}
