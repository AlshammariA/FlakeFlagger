@Test(expected=WroRuntimeException.class) public void testInvalidPostProcessorSet(){
  final Properties props=new Properties();
  props.setProperty(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS,"invalid");
  victim.setProperties(props);
  victim.getPostProcessors();
}
