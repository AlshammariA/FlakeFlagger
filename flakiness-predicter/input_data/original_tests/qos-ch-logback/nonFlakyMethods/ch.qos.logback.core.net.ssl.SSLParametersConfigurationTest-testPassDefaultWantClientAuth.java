@Test public void testPassDefaultWantClientAuth() throws Exception {
  configurable.setWantClientAuth(true);
  configuration.configure(configurable);
  assertTrue(configurable.isWantClientAuth());
}
