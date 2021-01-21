@Test(timeout=5000) public void schedulableAddedAfterStartShouldBeScheduledImmediately() throws Exception {
  injector=createInjector();
  start(injector);
  injector.getInstance(MockScheduled.class);
  MockScheduled.countDownLatch.await(5000,TimeUnit.MILLISECONDS);
}
