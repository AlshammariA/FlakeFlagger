@Test public void shouldInjectDecoratedProcessor(){
  final TestProcessor testProcessor=new TestProcessor();
  final ResourcePreProcessor processor=CopyrightKeeperProcessorDecorator.decorate(testProcessor);
  final Injector injector=InjectorBuilder.create(new BaseWroManagerFactory()).build();
  injector.inject(processor);
  assertNotNull(testProcessor.context);
}
