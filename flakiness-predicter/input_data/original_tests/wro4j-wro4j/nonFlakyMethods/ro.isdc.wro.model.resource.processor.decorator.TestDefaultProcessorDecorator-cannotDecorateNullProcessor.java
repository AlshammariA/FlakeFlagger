@Test(expected=NullPointerException.class) public void cannotDecorateNullProcessor(){
  new DefaultProcessorDecorator(null,false);
}
