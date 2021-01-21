@Test public void shouldUseWroConfigurationFoundInServletContext() throws Exception {
  final WroConfiguration config=new WroConfiguration();
  config.setCacheUpdatePeriod(1000);
  when(mockServletContextAttributeHelper.getWroConfiguration()).thenReturn(config);
  doAnswer(new Answer<Void>(){
    public Void answer(    InvocationOnMock invocation) throws Throwable {
      assertSame(config,Context.get().getConfig());
      return null;
    }
  }
).when(mockFilterChain).doFilter(Mockito.any(HttpServletRequest.class),Mockito.any(HttpServletResponse.class));
  victim.doFilter(mockRequest,mockResponse,mockFilterChain);
  verify(mockFilterChain,Mockito.times(1)).doFilter(Mockito.any(HttpServletRequest.class),Mockito.any(HttpServletResponse.class));
}
