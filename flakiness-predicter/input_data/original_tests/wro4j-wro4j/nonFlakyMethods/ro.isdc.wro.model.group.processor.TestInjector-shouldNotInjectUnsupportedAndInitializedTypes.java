@Test(expected=WroRuntimeException.class) public void shouldNotInjectUnsupportedAndInitializedTypes(){
  final String initialValue="initial";
  final Callable<?> object=new Callable<Void>(){
    @Inject String unsupportedInitializedType=initialValue;
    public Void call() throws Exception {
      assertEquals(initialValue,unsupportedInitializedType);
      return null;
    }
  }
;
  victim.inject(object);
}
