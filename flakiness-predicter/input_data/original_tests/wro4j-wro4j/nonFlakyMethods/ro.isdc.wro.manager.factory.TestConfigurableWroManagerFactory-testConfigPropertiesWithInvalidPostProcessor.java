@Test(expected=WroRuntimeException.class) public void testConfigPropertiesWithInvalidPostProcessor(){
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS,"INVALID");
  victim.setConfigProperties(configProperties);
  createManager();
  processorsFactory.getPostProcessors();
}
