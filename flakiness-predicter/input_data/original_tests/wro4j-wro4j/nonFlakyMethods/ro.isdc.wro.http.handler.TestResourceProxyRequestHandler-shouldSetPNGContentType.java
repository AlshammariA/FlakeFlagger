@Test public void shouldSetPNGContentType() throws IOException {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.png";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  victim.handle(request,response);
  verify(response,times(1)).setContentType("image/png");
}
