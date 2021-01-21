@Test public void serviceShouldNotBeStartedIfExplicitlyBoundAndNotSingleton(){
  Injector injector=createInjector(new AbstractModule(){
    @Override protected void configure(){
      bind(MockService.class);
    }
  }
);
  start(injector);
  assertThat(MockService.started,equalTo(0));
}
