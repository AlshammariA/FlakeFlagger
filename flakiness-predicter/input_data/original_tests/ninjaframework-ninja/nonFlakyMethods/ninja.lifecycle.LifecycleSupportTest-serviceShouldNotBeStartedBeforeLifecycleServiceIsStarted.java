@Test public void serviceShouldNotBeStartedBeforeLifecycleServiceIsStarted(){
  createInjector().getInstance(MockService.class);
  assertThat(MockService.started,equalTo(0));
}
