@Test public void testSetNeedClientAuth() throws Exception {
  configuration.setNeedClientAuth(true);
  configuration.configure(configurable);
  assertTrue(configurable.isNeedClientAuth());
}
