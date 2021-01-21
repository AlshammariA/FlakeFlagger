@Test public void testPassDefaultCipherSuites() throws Exception {
  final String[] cipherSuites=new String[]{"A"};
  configurable.setDefaultCipherSuites(cipherSuites);
  configuration.configure(configurable);
  assertTrue(Arrays.equals(cipherSuites,configurable.getEnabledCipherSuites()));
}
