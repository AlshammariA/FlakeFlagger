@Test(expected=UnauthorizedRequestException.class) public void cannotProxyUnauthorizedResources() throws IOException {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.css";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(false);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  when(mockUriLocator.locate(anyString())).thenReturn(new ClasspathUriLocator().locate(resourceUri));
  victim.handle(request,response);
}
