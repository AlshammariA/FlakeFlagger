@Test(expected=NullPointerException.class) public void cannotDecorateNullObject(){
  DefaultSynchronizedCacheStrategyDecorator.decorate(null);
}
