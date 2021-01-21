@Test(expected=WroRuntimeException.class) public void cannotInjectUnsupportedInnerObject() throws Exception {
  final Callable<?> outer=new Callable<Void>(){
    @Inject private final Callable<?> inner=new Callable<Void>(){
      @Inject UriLocatorFactory locatorFactory;
      public Void call() throws Exception {
        Assert.assertNotNull(locatorFactory);
        return null;
      }
    }
;
    public Void call() throws Exception {
      inner.call();
      return null;
    }
  }
;
  victim.inject(outer);
  outer.call();
}
