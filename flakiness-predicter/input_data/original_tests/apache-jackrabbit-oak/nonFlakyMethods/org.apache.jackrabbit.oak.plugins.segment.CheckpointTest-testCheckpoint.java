@Test public void testCheckpoint() throws CommitFailedException {
  SegmentNodeStore store=new SegmentNodeStore(new MemoryStore());
  addTestNode(store,"test-checkpoint");
  verifyNS(store,true);
  rmTestNode(store,"test-checkpoint");
  verifyNS(store,false);
  store.retrieve("missing-checkpoint");
}
