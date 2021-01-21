@Test public void testConfigureDebugWithOnlyPropertiesFileSet(){
  factory=new PropertiesAndFilterConfigWroConfigurationFactory(filterConfig){
    @Override protected Properties newDefaultProperties(){
      final Properties props=new Properties();
      props.put(ConfigConstants.debug.name(),Boolean.TRUE.toString());
      return props;
    }
  }
;
  final WroConfiguration config=factory.create();
  Assert.assertEquals(true,config.isDebug());
}
