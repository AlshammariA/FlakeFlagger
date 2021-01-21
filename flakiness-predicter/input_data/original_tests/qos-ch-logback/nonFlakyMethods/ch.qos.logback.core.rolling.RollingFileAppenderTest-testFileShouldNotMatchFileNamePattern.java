/** 
 * Test for http://jira.qos.ch/browse/LOGBACK-796
 */
@Test public void testFileShouldNotMatchFileNamePattern(){
  rfa.setContext(context);
  rfa.setFile(CoreTestConstants.OUTPUT_DIR_PREFIX + "x-2013-04.log");
  tbrp.setFileNamePattern(CoreTestConstants.OUTPUT_DIR_PREFIX + "x-%d{yyyy-MM}.log");
  tbrp.start();
  rfa.setRollingPolicy(tbrp);
  rfa.start();
  StatusChecker statusChecker=new StatusChecker(context);
  final String msg="File property collides with fileNamePattern. Aborting.";
  boolean containsMatch=statusChecker.containsMatch(Status.ERROR,msg);
  assertTrue("Missing error: " + msg,containsMatch);
}
