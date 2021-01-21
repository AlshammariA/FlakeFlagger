@Test(expected=CommitFailedException.class) public void blockCommits() throws CommitFailedException {
  limiter.blockCommits();
  limiter.processCommit(EMPTY_NODE,AFTER,null);
}
