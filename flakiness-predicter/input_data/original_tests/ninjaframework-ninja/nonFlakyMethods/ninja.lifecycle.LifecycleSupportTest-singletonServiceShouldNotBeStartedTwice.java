@Test public void singletonServiceShouldNotBeStartedTwice(){
  Injector injector=createInjector();
  injector.getInstance(MockSingletonService.class);
  injector.getInstance(MockSingletonService.class);
  start(injector);
  assertThat(MockSingletonService.started,equalTo(1));
}
