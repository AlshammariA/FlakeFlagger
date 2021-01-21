@Test public void testPrudentModeLogicalImplications(){
  rfa.setContext(context);
  rfa.setFile("some non null value");
  rfa.setAppend(false);
  rfa.setPrudent(true);
  tbrp.setFileNamePattern(CoreTestConstants.OUTPUT_DIR_PREFIX + "toto-%d.log");
  tbrp.start();
  rfa.setRollingPolicy(tbrp);
  rfa.start();
  assertTrue(rfa.isAppend());
  assertNull(rfa.rawFileProperty());
  assertTrue(rfa.isStarted());
}
