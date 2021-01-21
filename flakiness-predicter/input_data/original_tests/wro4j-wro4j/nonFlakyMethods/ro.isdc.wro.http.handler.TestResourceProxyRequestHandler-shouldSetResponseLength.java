@Test public void shouldSetResponseLength() throws IOException {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.css";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  when(mockUriLocator.locate(anyString())).thenReturn(new ClasspathUriLocator().locate(resourceUri));
  victim.handle(request,response);
  final int expectedLength=IOUtils.toString(getInputStream("test.css")).length();
  verify(response,times(1)).setContentLength(expectedLength);
}
