@Test public void shouldInvokePostProcessorWhenMinimizeIsRequired() throws Exception {
  victim=new MinimizeAwareProcessorDecorator(mockPostProcessor,true);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(mockPostProcessor,Mockito.atLeastOnce()).process(Mockito.any(Reader.class),Mockito.any(Writer.class));
}
