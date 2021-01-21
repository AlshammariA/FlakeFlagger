@Test public void shouldComputeIsMinimizeFlagOfDeepNestedDecoratedProcessor(){
  final ProcessorDecorator processor=new ProcessorDecorator(new ProcessorDecorator(new ProcessorDecorator(new JSMinProcessor())));
  assertTrue(processor.isMinimize());
}
