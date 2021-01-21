@Test public void shouldNotInvokeMinimizePreProcessorWhenMinimizeIsNotRequired() throws Exception {
  final ResourcePreProcessor processor=Mockito.spy(new JSMinProcessor());
  victim=new MinimizeAwareProcessorDecorator(processor,false);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(processor,Mockito.never()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
