@Test public void shouldAcceptRequestsWithCorrectURI(){
  when(mockRequest.getRequestURI()).thenReturn(ModelAsJsonRequestHandler.ENDPOINT_URI);
  assertTrue(victim.accept(mockRequest));
}
