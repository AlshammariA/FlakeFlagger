@Test public void testSetExcludedProtocols() throws Exception {
  configurable.setSupportedProtocols(new String[]{"A","B"});
  configuration.setExcludedProtocols("A");
  configuration.configure(configurable);
  assertTrue(Arrays.equals(new String[]{"B"},configurable.getEnabledProtocols()));
}
