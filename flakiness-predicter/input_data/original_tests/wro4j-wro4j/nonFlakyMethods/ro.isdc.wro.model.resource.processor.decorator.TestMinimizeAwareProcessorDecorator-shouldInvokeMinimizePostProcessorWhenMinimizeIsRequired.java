@Test public void shouldInvokeMinimizePostProcessorWhenMinimizeIsRequired() throws Exception {
  final MinimizeAwareProcessor processor=Mockito.spy(new MinimizeAwareProcessor());
  victim=new MinimizeAwareProcessorDecorator(processor,true);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(processor,Mockito.atLeastOnce()).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
