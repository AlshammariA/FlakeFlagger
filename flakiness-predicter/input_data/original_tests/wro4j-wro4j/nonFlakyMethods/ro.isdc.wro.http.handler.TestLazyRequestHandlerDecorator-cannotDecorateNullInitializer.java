@Test(expected=NullPointerException.class) public void cannotDecorateNullInitializer(){
  new LazyRequestHandlerDecorator(null);
}
