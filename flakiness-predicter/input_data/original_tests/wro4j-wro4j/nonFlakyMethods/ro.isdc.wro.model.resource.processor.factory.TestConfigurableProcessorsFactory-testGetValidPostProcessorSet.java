@Test public void testGetValidPostProcessorSet(){
  final Map<String,ResourcePostProcessor> map=new HashMap<String,ResourcePostProcessor>();
  map.put("valid",Mockito.mock(ResourcePostProcessor.class));
  final Properties props=new Properties();
  props.setProperty(ConfigurableProcessorsFactory.PARAM_POST_PROCESSORS,"valid");
  victim.setPostProcessorsMap(map);
  victim.setProperties(props);
  assertEquals(1,victim.getPostProcessors().size());
}
