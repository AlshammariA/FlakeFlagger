@Test(expected=NullPointerException.class) public void cannotDecorateModelFactoryWithNullTransformers(){
  DefaultWroModelFactoryDecorator.decorate(new XmlModelFactory(),null);
}
