@Test public void shouldReturnRelativeResource() throws IOException {
  final String resourceUri="/" + packagePath + "/"+ "test.css";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(mockUriLocator.locate(resourceUri)).thenReturn(getInputStream("test.css"));
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  victim.handle(request,response);
  final String body=outputStream.toString();
  final String expectedBody=IOUtils.toString(getInputStream("test.css"));
  verify(mockUriLocator,times(1)).locate(resourceUri);
  assertEquals(expectedBody,body);
}
