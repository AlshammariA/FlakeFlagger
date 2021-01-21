@Test public void testConfigureDebugWithPropertiesFileSet(){
  factory=new PropertiesAndFilterConfigWroConfigurationFactory(filterConfig){
    @Override protected Properties newDefaultProperties(){
      final Properties props=new Properties();
      props.put(ConfigConstants.debug.name(),Boolean.TRUE.toString());
      return props;
    }
  }
;
  Mockito.when(filterConfig.getInitParameter(ConfigConstants.debug.name())).thenReturn(Boolean.FALSE.toString());
  final WroConfiguration config=factory.create();
  Assert.assertEquals(false,config.isDebug());
}
