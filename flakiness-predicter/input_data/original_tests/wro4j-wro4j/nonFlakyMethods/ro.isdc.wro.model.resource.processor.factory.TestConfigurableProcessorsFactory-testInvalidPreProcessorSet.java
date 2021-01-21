@Test(expected=WroRuntimeException.class) public void testInvalidPreProcessorSet(){
  final Properties props=new Properties();
  props.setProperty(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,"invalid");
  victim.setProperties(props);
  victim.getPreProcessors();
}
