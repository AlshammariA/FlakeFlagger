@Test public void shouldSetCorrectResopnsCodeBasedOnResourceChangeState() throws IOException {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.css";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  final long timeInFuture=new Date().getTime() + 10000;
  when(request.getDateHeader(HttpHeader.IF_MODIFIED_SINCE.toString())).thenReturn(timeInFuture);
  victim.handle(request,response);
  verify(response).setStatus(HttpServletResponse.SC_NOT_MODIFIED);
  final long longTimeAgo=123L;
  when(request.getDateHeader(HttpHeader.IF_MODIFIED_SINCE.toString())).thenReturn(longTimeAgo);
  victim.handle(request,response);
  verify(response).setStatus(Mockito.eq(HttpServletResponse.SC_OK));
}
