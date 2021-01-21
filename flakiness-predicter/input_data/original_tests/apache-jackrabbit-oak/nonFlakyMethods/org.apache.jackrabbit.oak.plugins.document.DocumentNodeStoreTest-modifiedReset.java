@Test public void modifiedReset() throws Exception {
  Clock clock=new Clock.Virtual();
  clock.waitUntil(System.currentTimeMillis());
  Revision.setClock(clock);
  MemoryDocumentStore docStore=new MemoryDocumentStore();
  DocumentNodeStore ns1=new DocumentMK.Builder().setDocumentStore(docStore).setClusterId(1).setAsyncDelay(0).clock(clock).getNodeStore();
  NodeBuilder builder1=ns1.getRoot().builder();
  builder1.child("node");
  ns1.merge(builder1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  ns1.runBackgroundOperations();
  DocumentNodeStore ns2=new DocumentMK.Builder().setDocumentStore(docStore).setClusterId(2).setAsyncDelay(0).clock(clock).getNodeStore();
  NodeBuilder builder2=ns2.getRoot().builder();
  builder2.child("node").child("child-2");
  ns2.merge(builder2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  clock.waitUntil(System.currentTimeMillis() + SECONDS.toMillis(MODIFIED_IN_SECS_RESOLUTION + 1));
  builder1=ns1.getRoot().builder();
  builder1.child("node").child("child-1");
  ns1.merge(builder1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  ns1.runBackgroundOperations();
  NodeDocument doc=docStore.find(NODES,Utils.getIdFromPath("/node"));
  Long mod1=(Long)doc.get(MODIFIED_IN_SECS);
  assertNotNull(mod1);
  ns2.runBackgroundOperations();
  doc=docStore.find(NODES,Utils.getIdFromPath("/node"));
  Long mod2=(Long)doc.get(MODIFIED_IN_SECS);
  assertTrue("" + mod2 + " < "+ mod1,mod2 >= mod1);
  ns1.dispose();
  ns2.dispose();
}
