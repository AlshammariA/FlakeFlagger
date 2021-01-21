@Test public void delayCommits() throws CommitFailedException {
  limiter.setDelay(1000);
  long t0=Clock.ACCURATE.getTime();
  assertSame(AFTER,limiter.processCommit(EMPTY_NODE,AFTER,null));
  assertTrue(Clock.ACCURATE.getTime() - t0 >= 1000);
}
