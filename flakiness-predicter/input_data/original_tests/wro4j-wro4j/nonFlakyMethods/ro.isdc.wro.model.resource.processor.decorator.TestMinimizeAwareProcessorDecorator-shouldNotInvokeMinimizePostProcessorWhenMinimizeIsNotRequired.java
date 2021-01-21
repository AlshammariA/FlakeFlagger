@Test public void shouldNotInvokeMinimizePostProcessorWhenMinimizeIsNotRequired() throws Exception {
  final ResourcePostProcessor processor=Mockito.spy(new JSMinProcessor());
  victim=new MinimizeAwareProcessorDecorator(processor,false);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(processor,Mockito.never()).process(Mockito.any(Reader.class),Mockito.any(Writer.class));
}
