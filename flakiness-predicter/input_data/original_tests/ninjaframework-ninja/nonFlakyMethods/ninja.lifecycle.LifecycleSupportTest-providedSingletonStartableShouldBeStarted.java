@Test public void providedSingletonStartableShouldBeStarted(){
  Injector injector=createInjector(new AbstractModule(){
    @Override protected void configure(){
    }
    @Provides @Singleton public MockSingletonService provide(){
      return new MockSingletonService();
    }
  }
);
  start(injector);
  assertThat(MockSingletonService.started,equalTo(1));
}
