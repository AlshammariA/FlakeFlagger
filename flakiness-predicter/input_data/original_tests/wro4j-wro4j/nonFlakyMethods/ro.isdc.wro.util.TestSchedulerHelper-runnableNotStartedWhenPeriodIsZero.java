@Test public void runnableNotStartedWhenPeriodIsZero(){
  createAndRunHelperForTest(createSleepingRunnable(1000),0,TimeUnit.SECONDS);
}
