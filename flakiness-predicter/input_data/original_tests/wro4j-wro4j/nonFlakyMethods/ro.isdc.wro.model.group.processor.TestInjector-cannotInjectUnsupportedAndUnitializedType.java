@Test(expected=WroRuntimeException.class) public void cannotInjectUnsupportedAndUnitializedType(){
  initializeValidInjector();
  final Object inner=new Object(){
    @Inject private Object object;
  }
;
  victim.inject(inner);
}
