@Test public void testSetExcludedCipherSuites() throws Exception {
  configurable.setSupportedCipherSuites(new String[]{"A","B"});
  configuration.setExcludedCipherSuites("A");
  configuration.configure(configurable);
  assertTrue(Arrays.equals(new String[]{"B"},configurable.getEnabledCipherSuites()));
}
