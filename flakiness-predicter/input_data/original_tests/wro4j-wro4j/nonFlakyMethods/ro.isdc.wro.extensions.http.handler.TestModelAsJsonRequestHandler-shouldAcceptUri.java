@Test public void shouldAcceptUri(){
  when(mockRequest.getRequestURI()).thenReturn("wroApi/model");
  final boolean accept=victim.accept(mockRequest);
  assertTrue(accept);
}
