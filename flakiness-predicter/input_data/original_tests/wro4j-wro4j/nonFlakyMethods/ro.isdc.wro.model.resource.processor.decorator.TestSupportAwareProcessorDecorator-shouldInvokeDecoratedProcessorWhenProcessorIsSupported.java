@Test public void shouldInvokeDecoratedProcessorWhenProcessorIsSupported() throws Exception {
  Mockito.when(mockProcessor.isSupported()).thenReturn(true);
  victim=new SupportAwareProcessorDecorator(mockProcessor);
  victim.process(mockResource,mockReader,mockWriter);
  Mockito.verify(mockProcessor).process(Mockito.any(Resource.class),Mockito.any(Reader.class),Mockito.any(Writer.class));
}
