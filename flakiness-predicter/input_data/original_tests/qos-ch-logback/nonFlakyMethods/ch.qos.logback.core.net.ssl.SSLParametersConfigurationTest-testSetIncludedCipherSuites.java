@Test public void testSetIncludedCipherSuites() throws Exception {
  configurable.setSupportedCipherSuites(new String[]{"A","B","C","D"});
  configuration.setIncludedCipherSuites("A,B ,C, D");
  configuration.configure(configurable);
  assertTrue(Arrays.equals(new String[]{"A","B","C","D"},configurable.getEnabledCipherSuites()));
}
