@Test public void stopTimeBasedRollingPolicy(){
  rfa.setContext(context);
  tbrp.setFileNamePattern(CoreTestConstants.OUTPUT_DIR_PREFIX + "toto-%d.log.zip");
  tbrp.start();
  rfa.setRollingPolicy(tbrp);
  rfa.start();
  StatusPrinter.print(context);
  assertTrue(tbrp.isStarted());
  assertTrue(rfa.isStarted());
  rfa.stop();
  assertFalse(rfa.isStarted());
  assertFalse(tbrp.isStarted());
}
