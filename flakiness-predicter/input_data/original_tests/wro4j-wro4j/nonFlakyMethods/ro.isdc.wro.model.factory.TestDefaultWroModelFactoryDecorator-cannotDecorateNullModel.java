@Test(expected=NullPointerException.class) public void cannotDecorateNullModel(){
  DefaultWroModelFactoryDecorator.decorate(null,emptyTransformers);
}
