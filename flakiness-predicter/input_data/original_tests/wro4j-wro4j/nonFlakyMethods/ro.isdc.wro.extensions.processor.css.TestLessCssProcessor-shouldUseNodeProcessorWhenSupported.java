@Test public void shouldUseNodeProcessorWhenSupported() throws Exception {
  when(mockNodeProcessor.isSupported()).thenReturn(true);
  victim.process(mockResource,mockReader,mockWriter);
  verify(mockNodeProcessor,Mockito.times(1)).process(mockResource,mockReader,mockWriter);
  verify(mockRhinoProcessor,Mockito.never()).process(mockResource,mockReader,mockWriter);
}
