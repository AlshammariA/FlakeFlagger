@Test(expected=WroRuntimeException.class) public void shouldThrowExceptionWhenProcessorIsNotSupported() throws Exception {
  Mockito.when(mockProcessor.isSupported()).thenReturn(false);
  victim=new SupportAwareProcessorDecorator(mockProcessor);
  victim.process(mockResource,mockReader,mockWriter);
}
