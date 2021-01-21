@Test public void testSetExcludedAndIncludedCipherSuites() throws Exception {
  configurable.setSupportedCipherSuites(new String[]{"A","B","C"});
  configuration.setIncludedCipherSuites("A, B");
  configuration.setExcludedCipherSuites("B");
  configuration.configure(configurable);
  assertTrue(Arrays.equals(new String[]{"A"},configurable.getEnabledCipherSuites()));
}
