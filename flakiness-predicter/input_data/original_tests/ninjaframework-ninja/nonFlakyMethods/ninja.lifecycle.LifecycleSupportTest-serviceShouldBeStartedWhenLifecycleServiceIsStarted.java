@Test public void serviceShouldBeStartedWhenLifecycleServiceIsStarted(){
  Injector injector=createInjector();
  injector.getInstance(MockService.class);
  start(injector);
  assertThat(MockService.started,equalTo(1));
}
