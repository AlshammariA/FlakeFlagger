@Test public void commit() throws CommitFailedException {
  assertSame(AFTER,limiter.processCommit(EMPTY_NODE,AFTER,null));
}
