/** 
 * This test ensures that when "configuration" init-param is used, it will override the debug property for backward compatibility.
 */
@Test public void testConfigurationTypeBackwardCompatibility(){
  Mockito.when(filterConfig.getInitParameter(ConfigConstants.debug.name())).thenReturn("true");
  Mockito.when(filterConfig.getInitParameter(FilterConfigWroConfigurationFactory.PARAM_CONFIGURATION)).thenReturn(FilterConfigWroConfigurationFactory.PARAM_VALUE_DEPLOYMENT);
  factory=new FilterConfigWroConfigurationFactory(filterConfig);
  final WroConfiguration config=factory.create();
  Assert.assertEquals(false,config.isDebug());
}
