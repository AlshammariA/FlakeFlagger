@Test(expected=NullPointerException.class) public void cannotAcceptNullCriteria(){
  new DefaultProcessorDecorator(mockProcessor,null);
}
