@Test public void testStopWhenNotStarted() throws Exception {
  appender.stop();
  assertEquals(0,runner.getStartCount());
}
