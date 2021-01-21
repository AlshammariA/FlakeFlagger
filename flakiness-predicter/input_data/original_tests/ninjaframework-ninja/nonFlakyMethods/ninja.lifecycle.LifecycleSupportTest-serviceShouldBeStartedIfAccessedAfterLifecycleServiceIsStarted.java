@Test public void serviceShouldBeStartedIfAccessedAfterLifecycleServiceIsStarted(){
  Injector injector=createInjector();
  start(injector);
  injector.getInstance(MockService.class);
  assertThat(MockService.started,equalTo(1));
}
