@Test(expected=NullPointerException.class) public void cannotDecorateNullObject(){
  new CacheKeyFactoryDecorator(null);
}
