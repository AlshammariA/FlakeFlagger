@Test public void shouldInitializeContextForChainedFilters() throws Exception {
  doAnswer(new Answer<Void>(){
    public Void answer(    InvocationOnMock invocation) throws Throwable {
      assertTrue(Context.isContextSet());
      return null;
    }
  }
).when(mockFilterChain).doFilter(Mockito.any(HttpServletRequest.class),Mockito.any(HttpServletResponse.class));
  victim.doFilter(mockRequest,mockResponse,mockFilterChain);
  verify(mockFilterChain,times(1)).doFilter(Mockito.any(HttpServletRequest.class),Mockito.any(HttpServletResponse.class));
  assertFalse(Context.isContextSet());
}
