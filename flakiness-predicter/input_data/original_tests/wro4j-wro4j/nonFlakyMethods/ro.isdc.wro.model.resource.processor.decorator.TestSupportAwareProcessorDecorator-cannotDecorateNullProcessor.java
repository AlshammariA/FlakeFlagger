@Test(expected=NullPointerException.class) public void cannotDecorateNullProcessor(){
  new SupportAwareProcessorDecorator(null);
}
