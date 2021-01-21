@Test public void shouldInvokeModelAsJsonRequestHandler() throws Exception {
  when(mockRequest.getRequestURI()).thenReturn(ModelAsJsonRequestHandler.ENDPOINT_URI);
  victim.doFilter(mockRequest,mockResponse,mockFilterChain);
  Mockito.verify(mockFilterChain,Mockito.never()).doFilter(Mockito.any(ServletRequest.class),Mockito.any(ServletResponse.class));
}
