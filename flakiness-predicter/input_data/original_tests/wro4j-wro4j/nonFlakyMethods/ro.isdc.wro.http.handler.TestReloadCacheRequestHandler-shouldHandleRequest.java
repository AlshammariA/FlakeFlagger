@Test public void shouldHandleRequest(){
  when(request.getRequestURI()).thenReturn("wroApi/reloadCache");
  assertTrue(victim.accept(request));
}
