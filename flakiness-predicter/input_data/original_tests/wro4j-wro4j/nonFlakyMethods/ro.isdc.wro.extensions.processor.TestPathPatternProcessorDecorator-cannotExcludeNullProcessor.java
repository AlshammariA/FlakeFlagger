@Test(expected=NullPointerException.class) public void cannotExcludeNullProcessor(){
  PathPatternProcessorDecorator.include(null,"");
}
