@Test(expected=NullPointerException.class) public void cannotDecorateNullProcessor(){
  new ExceptionHandlingProcessorDecorator(null);
}
