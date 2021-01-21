@Test public void shouldNotInvokeRunnableImmediatelyAfterScheduleIsInvoked() throws Exception {
  helper=SchedulerHelper.create(new DestroyableLazyInitializer<Runnable>(){
    @Override protected Runnable initialize(){
      return mockRunnable;
    }
  }
);
  helper.scheduleWithPeriod(7200);
  Thread.sleep(10);
  verify(mockRunnable,Mockito.never()).run();
}
