@Test public void testPassDefaultNeedClientAuth() throws Exception {
  configurable.setNeedClientAuth(true);
  configuration.configure(configurable);
  assertTrue(configurable.isNeedClientAuth());
}
