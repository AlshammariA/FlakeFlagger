@Test public void testMinimizeAwareDecorator1(){
  final ResourcePreProcessor decoratedProcessor=new JSMinProcessor();
  final ResourcePreProcessor processor=ExtensionsAwareProcessorDecorator.decorate(decoratedProcessor);
  Assert.assertTrue(new ProcessorDecorator(processor).isMinimize());
}
