@Test public void disposablesShouldBeDisposedOf(){
  Injector injector=createInjector();
  injector.getInstance(MockService.class);
  start(injector);
  stop(injector);
  assertThat(MockService.disposed,equalTo(1));
}
