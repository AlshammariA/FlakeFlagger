@Test public void serviceShouldBeStartedIfExplicitlyBoundAsSingleton(){
  Injector injector=createInjector(new AbstractModule(){
    @Override protected void configure(){
      bind(MockService.class).toInstance(new MockService());
    }
  }
);
  start(injector);
  assertThat(MockService.started,equalTo(1));
}
