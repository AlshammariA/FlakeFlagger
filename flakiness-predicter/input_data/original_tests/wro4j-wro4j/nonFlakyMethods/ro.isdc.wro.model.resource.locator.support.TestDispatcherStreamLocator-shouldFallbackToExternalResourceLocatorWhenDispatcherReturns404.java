@Test public void shouldFallbackToExternalResourceLocatorWhenDispatcherReturns404() throws Exception {
  victim=new DispatcherStreamLocator(){
    @Override UriLocator createExternalResourceLocator(){
      return mockUriLocator;
    }
  }
;
  final String location="/some/location.js";
  when(mockRequest.getRequestDispatcher(location)).thenReturn(mockDispatcher);
  Mockito.doAnswer(new Answer<Void>(){
    public Void answer(    final InvocationOnMock invocation) throws Throwable {
      return null;
    }
  }
).when(mockDispatcher).include(Mockito.any(HttpServletRequest.class),Mockito.any(HttpServletResponse.class));
  victim.getInputStream(mockRequest,mockResponse,location);
  verify(mockUriLocator).locate(Mockito.anyString());
}
