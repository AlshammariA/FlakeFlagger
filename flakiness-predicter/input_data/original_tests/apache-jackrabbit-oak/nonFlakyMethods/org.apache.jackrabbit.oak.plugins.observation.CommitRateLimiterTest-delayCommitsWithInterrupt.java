@Test(expected=ExecutionException.class) public void delayCommitsWithInterrupt() throws InterruptedException, ExecutionException, TimeoutException {
  limiter.setDelay(10000);
  Thread t=new Thread(commit);
  t.start();
  t.interrupt();
  commit.get(1,TimeUnit.SECONDS);
}
