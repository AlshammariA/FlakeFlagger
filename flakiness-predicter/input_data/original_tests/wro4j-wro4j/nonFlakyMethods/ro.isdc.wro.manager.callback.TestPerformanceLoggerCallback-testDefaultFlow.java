@Test public void testDefaultFlow() throws Exception {
  callback.onBeforeModelCreated();
  Thread.sleep(10);
  callback.onAfterModelCreated();
  callback.onBeforeMerge();
  Thread.sleep(10);
  callback.onBeforePreProcess();
  callback.onAfterPreProcess();
  Thread.sleep(10);
  callback.onAfterMerge();
  Thread.sleep(10);
  callback.onBeforePostProcess();
  callback.onAfterPostProcess();
  Thread.sleep(10);
  callback.onProcessingComplete();
}
