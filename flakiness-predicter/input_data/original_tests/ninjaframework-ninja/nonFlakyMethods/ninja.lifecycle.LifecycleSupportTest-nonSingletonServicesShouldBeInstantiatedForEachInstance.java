@Test public void nonSingletonServicesShouldBeInstantiatedForEachInstance(){
  Injector injector=createInjector();
  injector.getInstance(MockService.class);
  injector.getInstance(MockService.class);
  start(injector);
  assertThat(MockService.started,equalTo(2));
}
