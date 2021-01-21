@Test public void shouldSetCorrectContentType() throws IOException, ServletException {
  when(mockRequest.getRequestURI()).thenReturn("wroAPI/model");
  victim.handle(mockRequest,mockResponse);
  verify(mockResponse,times(1)).setContentType("application/json");
  verify(mockResponse,times(1)).setStatus(HttpServletResponse.SC_OK);
}
