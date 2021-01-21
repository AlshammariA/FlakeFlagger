@Test public void shouldInvokePostProcessorWhenMinimizeIsNotRequired() throws Exception {
  victim=new MinimizeAwareProcessorDecorator(mockPostProcessor,false);
  initVictim();
  victim.process(mockReader,mockWriter);
  Mockito.verify(mockPostProcessor,Mockito.atLeastOnce()).process(Mockito.any(Reader.class),Mockito.any(Writer.class));
}
