@Test(expected=WroRuntimeException.class) public void cannotProcessWithExcludeWhenResourceIsUnknown() throws Exception {
  victim=PathPatternProcessorDecorator.exclude(mockProcessor,"");
  victim.process(mockReader,mockWriter);
}
