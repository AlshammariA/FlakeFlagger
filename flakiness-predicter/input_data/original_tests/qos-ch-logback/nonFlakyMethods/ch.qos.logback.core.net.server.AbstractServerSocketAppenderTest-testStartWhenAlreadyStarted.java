@Test public void testStartWhenAlreadyStarted() throws Exception {
  appender.start();
  appender.start();
  assertEquals(1,runner.getStartCount());
}
