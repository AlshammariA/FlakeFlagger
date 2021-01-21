@Test public void shouldAssumeResourceChangedWhenModifiedSinceHeaderExtractionFails() throws Exception {
  final String resourceUri="classpath:" + packagePath + "/"+ "test.css";
  when(mockAuthorizationManager.isAuthorized(resourceUri)).thenReturn(true);
  when(request.getParameter(ResourceProxyRequestHandler.PARAM_RESOURCE_ID)).thenReturn(resourceUri);
  when(request.getDateHeader(HttpHeader.IF_MODIFIED_SINCE.toString())).thenThrow(new IllegalArgumentException("BOOM!"));
  victim.handle(request,response);
  verify(response).setStatus(HttpServletResponse.SC_OK);
}
