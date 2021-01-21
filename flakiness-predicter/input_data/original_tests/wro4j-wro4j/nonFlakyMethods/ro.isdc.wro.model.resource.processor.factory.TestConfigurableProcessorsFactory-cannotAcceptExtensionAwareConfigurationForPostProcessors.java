@Test public void cannotAcceptExtensionAwareConfigurationForPostProcessors(){
  final Map<String,ResourcePreProcessor> map=new HashMap<String,ResourcePreProcessor>();
  final String extension="js";
  final String processorName="valid";
  map.put(processorName,Mockito.mock(ResourcePreProcessor.class));
  final Properties props=new Properties();
  props.setProperty(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS,String.format("%s.%s",processorName,extension));
  victim.setPreProcessorsMap(map);
  victim.setProperties(props);
  assertEquals(0,victim.getPreProcessors().size());
}
