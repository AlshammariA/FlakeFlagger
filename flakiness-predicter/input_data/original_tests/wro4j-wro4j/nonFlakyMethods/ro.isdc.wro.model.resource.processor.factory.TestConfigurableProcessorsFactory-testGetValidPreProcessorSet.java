@Test public void testGetValidPreProcessorSet(){
  final Map<String,ResourcePreProcessor> map=new HashMap<String,ResourcePreProcessor>();
  map.put("valid",Mockito.mock(ResourcePreProcessor.class));
  final Properties props=new Properties();
  props.setProperty(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,"valid");
  victim.setPreProcessorsMap(map);
  victim.setProperties(props);
  assertEquals(1,victim.getPreProcessors().size());
}
