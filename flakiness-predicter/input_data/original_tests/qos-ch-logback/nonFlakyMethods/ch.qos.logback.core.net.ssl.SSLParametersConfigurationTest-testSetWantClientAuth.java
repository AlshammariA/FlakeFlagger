@Test public void testSetWantClientAuth() throws Exception {
  configuration.setWantClientAuth(true);
  configuration.configure(configurable);
  assertTrue(configurable.isWantClientAuth());
}
