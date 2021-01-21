@Test public void testPrudentModeLogicalImplicationsOnCompression(){
  rfa.setContext(context);
  rfa.setAppend(false);
  rfa.setPrudent(true);
  tbrp.setFileNamePattern(CoreTestConstants.OUTPUT_DIR_PREFIX + "toto-%d.log.zip");
  tbrp.start();
  rfa.setRollingPolicy(tbrp);
  rfa.start();
  StatusChecker checker=new StatusChecker(context);
  assertFalse(rfa.isStarted());
  assertEquals(Status.ERROR,checker.getHighestLevel(0));
}
