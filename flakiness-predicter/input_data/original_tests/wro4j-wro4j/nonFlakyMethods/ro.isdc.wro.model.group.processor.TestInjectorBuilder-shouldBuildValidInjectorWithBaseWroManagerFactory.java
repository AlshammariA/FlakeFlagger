@Test public void shouldBuildValidInjectorWithBaseWroManagerFactory(){
  final Injector injector=InjectorBuilder.create(new BaseWroManagerFactory()).build();
  assertNotNull(injector);
  final Sample sample=new Sample();
  injector.inject(sample);
  assertNotNull(sample.namingStrategy);
  assertNotNull(sample.preProcessorExecutor);
  assertNotNull(sample.processorsFactory);
  assertNotNull(sample.uriLocatorFactory);
  assertNotNull(sample.callbackRegistry);
  assertSame(injector,sample.injector);
  assertNotNull(sample.groupsProcessor);
  assertNotNull(sample.metaDataFactory);
  assertNotNull(sample.cacheKeyFactory);
  assertNotNull(sample.bundleProcessor);
}
