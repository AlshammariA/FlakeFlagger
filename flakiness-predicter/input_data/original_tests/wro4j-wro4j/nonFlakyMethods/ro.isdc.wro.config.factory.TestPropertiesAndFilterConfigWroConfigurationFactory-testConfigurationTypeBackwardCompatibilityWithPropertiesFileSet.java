@Test public void testConfigurationTypeBackwardCompatibilityWithPropertiesFileSet(){
  factory=new PropertiesAndFilterConfigWroConfigurationFactory(filterConfig){
    @Override protected Properties newDefaultProperties(){
      final Properties props=new Properties();
      props.put(ConfigConstants.debug.name(),Boolean.TRUE.toString());
      return props;
    }
  }
;
  Mockito.when(filterConfig.getInitParameter(FilterConfigWroConfigurationFactory.PARAM_CONFIGURATION)).thenReturn(FilterConfigWroConfigurationFactory.PARAM_VALUE_DEPLOYMENT);
  final WroConfiguration config=factory.create();
  Assert.assertEquals(false,config.isDebug());
}
