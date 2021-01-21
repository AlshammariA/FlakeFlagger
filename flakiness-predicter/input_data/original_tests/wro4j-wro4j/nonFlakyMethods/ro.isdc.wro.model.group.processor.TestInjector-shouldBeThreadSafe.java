@Test public void shouldBeThreadSafe() throws Exception {
  initializeValidInjector();
  WroTestUtils.runConcurrently(new ContextPropagatingCallable<Void>(new Callable<Void>(){
    public Void call() throws Exception {
      victim.inject(new GroupsProcessor());
      return null;
    }
  }
));
}
