@Test(timeout=5000) public void schedulableShouldBeScheduledAfterStart() throws Exception {
  injector=createInjector(new AbstractModule(){
    @Override protected void configure(){
      bind(MockScheduled.class);
    }
  }
);
  start(injector);
  MockScheduled.countDownLatch.await(5000,TimeUnit.MILLISECONDS);
}
