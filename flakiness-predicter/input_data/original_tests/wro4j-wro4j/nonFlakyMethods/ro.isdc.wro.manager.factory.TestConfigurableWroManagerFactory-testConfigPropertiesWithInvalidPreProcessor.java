@Test(expected=WroRuntimeException.class) public void testConfigPropertiesWithInvalidPreProcessor(){
  final Properties configProperties=new Properties();
  configProperties.setProperty(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,"INVALID");
  victim.setConfigProperties(configProperties);
  createManager();
  processorsFactory.getPreProcessors();
}
