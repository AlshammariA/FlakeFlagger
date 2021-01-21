@Test public void shouldSetCSSContentType() throws IOException {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.css";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  victim.handle(request,response);
  verify(response,times(1)).setContentType("text/css; charset=UTF-8");
}
