@Test(expected=NullPointerException.class) public void cannotExclusdeNullPatterns(){
  final String[] patterns=null;
  PathPatternProcessorDecorator.exclude(mockProcessor,patterns);
}
