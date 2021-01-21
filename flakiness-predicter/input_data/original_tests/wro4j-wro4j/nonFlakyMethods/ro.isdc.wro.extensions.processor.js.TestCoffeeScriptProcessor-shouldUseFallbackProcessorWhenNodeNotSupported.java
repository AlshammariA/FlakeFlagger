@Test public void shouldUseFallbackProcessorWhenNodeNotSupported() throws Exception {
  when(mockNodeProcessor.isSupported()).thenReturn(false);
  victim.process(mockResource,mockReader,mockWriter);
  verify(mockNodeProcessor,Mockito.never()).process(mockResource,mockReader,mockWriter);
  verify(mockFallbackProcessor,Mockito.times(1)).process(mockResource,mockReader,mockWriter);
}
