@Test public void malformedURL() throws JoranException {
  System.setProperty(INCLUDE_KEY,"htp://logback.qos.ch");
  tc.doConfigure(TOP_BY_URL);
  assertEquals(Status.ERROR,statusChecker.getHighestLevel(0));
  assertTrue(statusChecker.containsException(MalformedURLException.class));
}
