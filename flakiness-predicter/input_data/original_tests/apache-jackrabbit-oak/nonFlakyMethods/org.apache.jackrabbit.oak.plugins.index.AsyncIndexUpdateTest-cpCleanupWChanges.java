@Test public void cpCleanupWChanges() throws Exception {
  MemoryNodeStore store=new MemoryNodeStore();
  IndexEditorProvider provider=new PropertyIndexEditorProvider();
  NodeBuilder builder=store.getRoot().builder();
  createIndexDefinition(builder.child(INDEX_DEFINITIONS_NAME),"rootIndex",true,false,ImmutableSet.of("foo"),null).setProperty(ASYNC_PROPERTY_NAME,"async");
  builder.child("testRoot").setProperty("foo","abc");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  assertTrue("Expecting no checkpoints",store.listCheckpoints().size() == 0);
  AsyncIndexUpdate async=new AsyncIndexUpdate("async",store,provider);
  async.run();
  assertTrue("Expecting one checkpoint",store.listCheckpoints().size() == 1);
  String firstCp=store.listCheckpoints().iterator().next();
  builder=store.getRoot().builder();
  builder.child("testRoot").setProperty("foo","def");
  store.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  async.run();
  assertTrue("Expecting one checkpoint",store.listCheckpoints().size() == 1);
  String secondCp=store.listCheckpoints().iterator().next();
  assertFalse("Store should keep only second checkpoint",secondCp.equals(firstCp));
}
