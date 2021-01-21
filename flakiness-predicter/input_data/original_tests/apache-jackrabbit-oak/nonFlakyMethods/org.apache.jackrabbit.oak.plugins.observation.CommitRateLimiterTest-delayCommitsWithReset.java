@Test public void delayCommitsWithReset() throws InterruptedException, ExecutionException, TimeoutException {
  limiter.setDelay(10000);
  new Thread(commit).start();
  limiter.setDelay(0);
  assertTrue(commit.get(1,TimeUnit.SECONDS) >= 100);
}
