@Test public void testSetIncludedAndExcludedProtocols() throws Exception {
  configurable.setSupportedProtocols(new String[]{"A","B","C"});
  configuration.setIncludedProtocols("A, B");
  configuration.setExcludedProtocols("B");
  configuration.configure(configurable);
  assertTrue(Arrays.equals(new String[]{"A"},configurable.getEnabledProtocols()));
}
