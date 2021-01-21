@Test public void testAsyncPropertyLookup() throws Exception {
  NodeStore store=new MemoryNodeStore();
  NodeBuilder builder=store.getRoot().builder();
  NodeBuilder def=createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"foo",true,false,of("foo"),null);
  def.setProperty(REINDEX_ASYNC_PROPERTY_NAME,true);
  builder.child("a").setProperty("foo","abc");
  builder.child("b").setProperty("foo",Arrays.asList("abc","def"),STRINGS);
  NodeState head=store.merge(builder,hook,EMPTY);
  FilterImpl f=createFilter(head,NT_BASE);
  PropertyIndexLookup lookup=new PropertyIndexLookup(head);
  try {
    assertEquals(of(),find(lookup,"foo","abc",f));
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
  AsyncIndexUpdate async=new AsyncIndexUpdate(ASYNC_REINDEX_VALUE,store,provider,true);
  async.run();
  assertEquals(ASYNC_REINDEX_VALUE,store.getRoot().getChildNode(INDEX_DEFINITIONS_NAME).getChildNode("foo").getString(ASYNC_PROPERTY_NAME));
  async.run();
  assertEquals(null,store.getRoot().getChildNode(INDEX_DEFINITIONS_NAME).getChildNode("foo").getString(ASYNC_PROPERTY_NAME));
  builder=store.getRoot().builder();
  builder.child("c").setProperty("foo","def");
  head=store.merge(builder,hook,EMPTY);
  f=createFilter(head,NT_BASE);
  lookup=new PropertyIndexLookup(head);
  assertEquals(ImmutableSet.of("b","c"),find(lookup,"foo","def",f));
}
