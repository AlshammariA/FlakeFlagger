@Test(expected=WroRuntimeException.class) public void cannotProcessWithIncludeWhenResourceIsUnknown() throws Exception {
  victim=PathPatternProcessorDecorator.include(mockProcessor,"");
  victim.process(mockReader,mockWriter);
}
