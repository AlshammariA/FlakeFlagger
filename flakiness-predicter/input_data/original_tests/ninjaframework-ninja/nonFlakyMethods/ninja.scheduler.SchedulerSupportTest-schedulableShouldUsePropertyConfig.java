@Test(timeout=5000) public void schedulableShouldUsePropertyConfig() throws Exception {
  injector=createInjector(new AbstractModule(){
    @Override protected void configure(){
      bind(Key.get(String.class,Names.named("delay.property"))).toInstance("10");
    }
  }
);
  injector.getInstance(MockPropertyScheduled.class);
  start(injector);
  MockPropertyScheduled.countDownLatch.await(5000,TimeUnit.MILLISECONDS);
}
