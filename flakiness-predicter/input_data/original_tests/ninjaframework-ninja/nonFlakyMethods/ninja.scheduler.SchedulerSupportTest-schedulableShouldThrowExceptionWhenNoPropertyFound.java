@Test(expected=FailedStartException.class) public void schedulableShouldThrowExceptionWhenNoPropertyFound() throws Exception {
  injector=createInjector();
  injector.getInstance(MockPropertyScheduled.class);
  start(injector);
}
