@Test public void shouldIdentifyProcessorSupport(){
  final SupportAwareProcessor supportAwareProcessor=mock(SupportAwareProcessor.class);
  final ProcessorDecorator decorator=new ProcessorDecorator(supportAwareProcessor);
  when(supportAwareProcessor.isSupported()).thenReturn(true);
  assertEquals(true,decorator.isSupported());
  when(supportAwareProcessor.isSupported()).thenReturn(false);
  assertEquals(false,decorator.isSupported());
}
