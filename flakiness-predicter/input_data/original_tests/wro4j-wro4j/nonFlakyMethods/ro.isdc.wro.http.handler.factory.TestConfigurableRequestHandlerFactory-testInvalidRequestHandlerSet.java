@Test(expected=WroRuntimeException.class) public void testInvalidRequestHandlerSet(){
  final Properties props=new Properties();
  props.setProperty(ConfigurableRequestHandlerFactory.KEY,"invalid");
  victim.setProperties(props);
  victim.getConfiguredStrategies();
}
