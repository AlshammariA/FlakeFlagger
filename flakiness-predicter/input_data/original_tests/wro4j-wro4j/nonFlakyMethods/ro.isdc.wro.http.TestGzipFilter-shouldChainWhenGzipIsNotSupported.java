@Test public void shouldChainWhenGzipIsNotSupported() throws Exception {
  victim.doFilter(mockRequest,mockResponse,mockFilterChain);
  verify(mockFilterChain,Mockito.times(1)).doFilter(mockRequest,mockResponse);
}
