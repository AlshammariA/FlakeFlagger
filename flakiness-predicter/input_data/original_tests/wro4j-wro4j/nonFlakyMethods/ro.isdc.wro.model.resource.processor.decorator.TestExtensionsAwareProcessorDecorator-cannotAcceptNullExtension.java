@Test(expected=NullPointerException.class) public void cannotAcceptNullExtension(){
  final ResourcePreProcessor decoratedProcessor=new JSMinProcessor();
  ExtensionsAwareProcessorDecorator.decorate(decoratedProcessor).addExtension(null);
}
