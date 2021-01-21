@Test public void testRelease() throws CommitFailedException {
  SegmentNodeStore store=new SegmentNodeStore(new MemoryStore());
  addTestNode(store,"test-checkpoint");
  String cp=verifyNS(store,true);
  store.release(cp);
  assertNull(store.retrieve(cp));
}
