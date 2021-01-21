@Test public void scheduleWithSamePeriods() throws Exception {
  helper=SchedulerHelper.create(new DestroyableLazyInitializer<Runnable>(){
    @Override protected Runnable initialize(){
      return createSleepingRunnable(10);
    }
  }
);
  helper.scheduleWithPeriod(10);
  Assert.assertEquals(10,helper.getPeriod());
  Thread.sleep(20);
  helper.scheduleWithPeriod(10);
  Assert.assertEquals(10,helper.getPeriod());
  Thread.sleep(30);
}
