@Test public void shouldNotAcceptCallsTo_OtherUris(){
  when(request.getRequestURI()).thenReturn("/wro/someOtherUri");
  assertFalse(victim.accept(request));
}
