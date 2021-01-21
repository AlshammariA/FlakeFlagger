@Test public void shouldInjectSupportedType() throws Exception {
  initializeValidInjector();
  final Callable<?> inner=new Callable<Void>(){
    @Inject private LifecycleCallbackRegistry object;
    public Void call() throws Exception {
      Assert.assertNotNull(object);
      return null;
    }
  }
;
  victim.inject(inner);
  inner.call();
}
