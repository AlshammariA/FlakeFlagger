@Test public void shouldNotRedundantlyDecorateCacheStrategy(){
  final WroModelFactory original=DefaultWroModelFactoryDecorator.decorate(new XmlModelFactory(),emptyTransformers);
  victim=DefaultWroModelFactoryDecorator.decorate(original,emptyTransformers);
  Assert.assertTrue(victim instanceof DefaultWroModelFactoryDecorator);
  Assert.assertSame(original,victim);
}
