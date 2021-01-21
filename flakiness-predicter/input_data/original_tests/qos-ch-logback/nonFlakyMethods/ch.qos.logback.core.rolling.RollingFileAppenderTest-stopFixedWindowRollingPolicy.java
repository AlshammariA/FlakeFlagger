@Test public void stopFixedWindowRollingPolicy(){
  rfa.setContext(context);
  rfa.setFile(CoreTestConstants.OUTPUT_DIR_PREFIX + "toto-.log");
  FixedWindowRollingPolicy fwRollingPolicy=new FixedWindowRollingPolicy();
  fwRollingPolicy.setContext(context);
  fwRollingPolicy.setFileNamePattern(CoreTestConstants.OUTPUT_DIR_PREFIX + "toto-%i.log.zip");
  fwRollingPolicy.setParent(rfa);
  fwRollingPolicy.start();
  SizeBasedTriggeringPolicy sbTriggeringPolicy=new SizeBasedTriggeringPolicy();
  sbTriggeringPolicy.setContext(context);
  sbTriggeringPolicy.start();
  rfa.setRollingPolicy(fwRollingPolicy);
  rfa.setTriggeringPolicy(sbTriggeringPolicy);
  rfa.start();
  StatusPrinter.print(context);
  assertTrue(fwRollingPolicy.isStarted());
  assertTrue(sbTriggeringPolicy.isStarted());
  assertTrue(rfa.isStarted());
  rfa.stop();
  assertFalse(rfa.isStarted());
  assertFalse(fwRollingPolicy.isStarted());
  assertFalse(sbTriggeringPolicy.isStarted());
}
