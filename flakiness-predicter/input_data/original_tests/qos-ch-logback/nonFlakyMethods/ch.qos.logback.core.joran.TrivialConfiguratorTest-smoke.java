@Test public void smoke() throws Exception {
  int oldBeginCount=IncAction.beginCount;
  int oldEndCount=IncAction.endCount;
  int oldErrorCount=IncAction.errorCount;
  doTest(CoreTestConstants.TEST_SRC_PREFIX + "input/joran/" + "inc.xml");
  assertEquals(oldErrorCount,IncAction.errorCount);
  assertEquals(oldBeginCount + 1,IncAction.beginCount);
  assertEquals(oldEndCount + 1,IncAction.endCount);
}
