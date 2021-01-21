@Test public void testSetIncludedProtocols() throws Exception {
  configurable.setSupportedProtocols(new String[]{"A","B","C","D"});
  configuration.setIncludedProtocols("A,B ,C, D");
  configuration.configure(configurable);
  assertTrue(Arrays.equals(new String[]{"A","B","C","D"},configurable.getEnabledProtocols()));
}
