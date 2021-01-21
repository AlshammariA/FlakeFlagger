@Test public void shouldDecorateCacheStrategy(){
  final WroModelFactory original=new XmlModelFactory();
  victim=DefaultWroModelFactoryDecorator.decorate(original,emptyTransformers);
  Assert.assertTrue(victim instanceof DefaultWroModelFactoryDecorator);
  Assert.assertSame(original,((ObjectDecorator<?>)victim).getDecoratedObject());
}
