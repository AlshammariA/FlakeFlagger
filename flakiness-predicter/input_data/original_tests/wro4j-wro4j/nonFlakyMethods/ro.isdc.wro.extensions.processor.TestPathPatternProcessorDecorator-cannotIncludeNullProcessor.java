@Test(expected=NullPointerException.class) public void cannotIncludeNullProcessor(){
  PathPatternProcessorDecorator.include(null,"");
}
