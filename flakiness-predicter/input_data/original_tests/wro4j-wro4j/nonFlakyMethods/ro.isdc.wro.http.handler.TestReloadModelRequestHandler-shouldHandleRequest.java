@Test public void shouldHandleRequest(){
  when(request.getRequestURI()).thenReturn("wroApi/reloadModel");
  assertTrue(victim.accept(request));
}
