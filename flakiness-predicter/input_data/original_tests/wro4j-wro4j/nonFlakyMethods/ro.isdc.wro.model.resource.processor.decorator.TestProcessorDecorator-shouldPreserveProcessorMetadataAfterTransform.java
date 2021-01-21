@Test public void shouldPreserveProcessorMetadataAfterTransform(){
  final ResourcePostProcessor postProcessor=new JSMinProcessor();
  final ProcessorDecorator decorator=new ProcessorDecorator(postProcessor);
  assertTrue(Arrays.equals(new ResourceType[]{ResourceType.JS},decorator.getSupportedResourceTypes()));
  assertTrue(decorator.isMinimize());
}
