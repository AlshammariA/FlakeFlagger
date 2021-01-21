@Test public void unorderedShouldOverrideDefault(){
  final Properties props=new Properties();
  props.setProperty(ConfigurableProcessorsFactory.PARAM_PRE_PROCESSORS,ConformColorsCssProcessor.ALIAS);
  victim.setProperties(props);
  assertSame(victim.getPreProcessors().iterator().next(),UnorderedProcessorProvider.CONFORM_COLORS);
}
