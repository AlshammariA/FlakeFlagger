@Test public void schedulableShouldNotBeScheduledBeforeStart() throws Exception {
  injector=createInjector();
  injector.getInstance(MockScheduled.class);
  Thread.sleep(100);
  assertThat(MockScheduled.countDownLatch.getCount(),equalTo(1L));
}
