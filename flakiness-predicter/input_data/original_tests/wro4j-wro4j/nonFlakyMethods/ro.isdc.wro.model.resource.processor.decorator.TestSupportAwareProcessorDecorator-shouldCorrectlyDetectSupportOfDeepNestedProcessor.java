@Test public void shouldCorrectlyDetectSupportOfDeepNestedProcessor(){
  victim=new SupportAwareProcessorDecorator(new ProcessorDecorator(new ProcessorDecorator(new JSMinProcessor())));
  assertTrue(victim.isSupported());
}
