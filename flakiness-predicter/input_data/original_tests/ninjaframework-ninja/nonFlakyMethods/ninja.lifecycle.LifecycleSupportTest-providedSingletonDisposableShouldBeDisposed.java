@Test public void providedSingletonDisposableShouldBeDisposed(){
  Injector injector=createInjector(new AbstractModule(){
    @Override protected void configure(){
    }
    @Provides @Singleton public MockSingletonService provide(){
      return new MockSingletonService();
    }
  }
);
  start(injector);
  stop(injector);
  assertThat(MockSingletonService.disposed,equalTo(1));
}
