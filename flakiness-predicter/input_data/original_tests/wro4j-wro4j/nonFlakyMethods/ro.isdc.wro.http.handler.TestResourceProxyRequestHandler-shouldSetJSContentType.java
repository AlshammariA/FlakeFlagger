@Test public void shouldSetJSContentType() throws IOException {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.js";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  victim.handle(request,response);
  verify(response,times(1)).setContentType("application/javascript; charset=UTF-8");
}
