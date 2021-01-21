@Test public void testRecover() throws Exception {
  NodeBuilder b1=ds1.getRoot().builder();
  b1.child("x").child("y");
  ds1.merge(b1,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  ds1.runBackgroundOperations();
  ds2.runBackgroundOperations();
  NodeBuilder b2=ds2.getRoot().builder();
  b2.child("x").setProperty("f1","b1");
  ds2.merge(b2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  ds2.runBackgroundOperations();
  b2=ds2.getRoot().builder();
  b2.child("x").child("y").child("z").setProperty("foo","bar");
  ds2.merge(b2,EmptyHook.INSTANCE,CommitInfo.EMPTY);
  ds1.runBackgroundOperations();
  NodeDocument z1=getDocument(ds1,"/x/y/z");
  NodeDocument y1=getDocument(ds1,"/x/y");
  NodeDocument x1=getDocument(ds1,"/x");
  Revision zlastRev2=z1.getLastRev().get(c2Id);
  assertNotNull(zlastRev2);
  assertNull(y1.getLastRev().get(c2Id));
  LastRevRecoveryAgent recovery=new LastRevRecoveryAgent(ds1);
  recovery.recover(Iterators.forArray(x1,z1),c2Id);
  assertEquals(zlastRev2,getDocument(ds1,"/x/y").getLastRev().get(c2Id));
  assertEquals(zlastRev2,getDocument(ds1,"/x").getLastRev().get(c2Id));
  assertEquals(zlastRev2,getDocument(ds1,"/").getLastRev().get(c2Id));
}
