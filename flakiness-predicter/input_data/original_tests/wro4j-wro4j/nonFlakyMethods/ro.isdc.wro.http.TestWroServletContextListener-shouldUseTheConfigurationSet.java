@Test public void shouldUseTheConfigurationSet(){
  final WroConfiguration configuration=new WroConfiguration();
  victim.setConfiguration(configuration);
  victim.contextInitialized(mockServletContextEvent);
  Assert.assertSame(configuration,victim.getConfiguration());
}
