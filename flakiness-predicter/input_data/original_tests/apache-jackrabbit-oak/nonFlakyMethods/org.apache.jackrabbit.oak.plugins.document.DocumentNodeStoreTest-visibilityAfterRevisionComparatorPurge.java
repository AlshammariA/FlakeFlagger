@Test public void visibilityAfterRevisionComparatorPurge() throws Exception {
  Clock clock=new Clock.Virtual();
  clock.waitUntil(System.currentTimeMillis());
  Revision.setClock(clock);
  MemoryDocumentStore docStore=new MemoryDocumentStore();
  DocumentNodeStore nodeStore1=new DocumentMK.Builder().setDocumentStore(docStore).setClusterId(1).setAsyncDelay(0).clock(clock).getNodeStore();
  nodeStore1.runBackgroundOperations();
  DocumentNodeStore nodeStore2=new DocumentMK.Builder().setDocumentStore(docStore).setClusterId(2).setAsyncDelay(0).clock(clock).getNodeStore();
  DocumentNodeStore nodeStore3=new DocumentMK.Builder().setDocumentStore(docStore).setClusterId(3).setAsyncDelay(0).clock(clock).getNodeStore();
  NodeDocument doc=docStore.find(NODES,Utils.getIdFromPath("/"));
  assertNotNull(doc);
  Revision created=doc.getLocalDeleted().firstKey();
  assertEquals(1,created.getClusterId());
  clock.waitUntil(System.currentTimeMillis() + DocumentNodeStore.REMEMBER_REVISION_ORDER_MILLIS / 2);
  NodeBuilder builder=nodeStore2.getRoot().builder();
  builder.setProperty("prop","value");
  nodeStore2.merge(builder,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  nodeStore2.runBackgroundOperations();
  clock.waitUntil(System.currentTimeMillis() + DocumentNodeStore.REMEMBER_REVISION_ORDER_MILLIS + 1000);
  nodeStore3.runBackgroundOperations();
  doc=docStore.find(NODES,Utils.getIdFromPath("/"));
  assertNotNull(doc);
  NodeState state=doc.getNodeAtRevision(nodeStore3,nodeStore3.getHeadRevision(),null);
  assertNotNull(state);
  nodeStore1.dispose();
  nodeStore2.dispose();
  nodeStore3.dispose();
}
