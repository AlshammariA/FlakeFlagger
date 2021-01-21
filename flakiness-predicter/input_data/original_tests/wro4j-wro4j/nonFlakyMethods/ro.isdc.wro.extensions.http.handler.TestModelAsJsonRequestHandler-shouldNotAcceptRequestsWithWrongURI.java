@Test public void shouldNotAcceptRequestsWithWrongURI(){
  when(mockRequest.getRequestURI()).thenReturn("/path/to/anotherURI");
  assertFalse(victim.accept(mockRequest));
}
