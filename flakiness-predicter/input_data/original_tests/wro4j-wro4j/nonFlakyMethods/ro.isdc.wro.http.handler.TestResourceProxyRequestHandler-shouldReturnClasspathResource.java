@Test public void shouldReturnClasspathResource() throws IOException {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.css";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  when(mockUriLocator.locate(anyString())).thenReturn(new ClasspathUriLocator().locate(resourceUri));
  victim.handle(request,response);
  final String body=outputStream.toString();
  final String expectedBody=IOUtils.toString(getInputStream("test.css"));
  assertEquals(expectedBody,body);
}
