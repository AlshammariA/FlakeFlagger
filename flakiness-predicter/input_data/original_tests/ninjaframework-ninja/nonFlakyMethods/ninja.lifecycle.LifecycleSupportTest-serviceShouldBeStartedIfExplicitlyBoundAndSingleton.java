@Test public void serviceShouldBeStartedIfExplicitlyBoundAndSingleton(){
  Injector injector=createInjector(new AbstractModule(){
    @Override protected void configure(){
      bind(MockSingletonService.class);
    }
  }
);
  start(injector);
  assertThat(MockSingletonService.started,equalTo(1));
}
