@Test(expected=NullPointerException.class) public void cannotIncludeNullPatterns(){
  final String[] patterns=null;
  PathPatternProcessorDecorator.include(mockProcessor,patterns);
}
