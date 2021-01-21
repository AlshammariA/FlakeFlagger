@Test public void testPassDefaultProtocols() throws Exception {
  final String[] protocols=new String[]{"A"};
  configurable.setDefaultProtocols(protocols);
  configuration.configure(configurable);
  assertTrue(Arrays.equals(protocols,configurable.getEnabledProtocols()));
}
