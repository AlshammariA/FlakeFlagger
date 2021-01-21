@Test public void shouldReturnsResourceIncludedByDispatcher() throws Exception {
  final String content="SomeNonEmptyContent";
  when(mockRequest.getRequestDispatcher(Mockito.anyString())).thenReturn(mockDispatcher);
  doAnswer(new Answer<Void>(){
    public Void answer(    final InvocationOnMock invocation) throws Throwable {
      final HttpServletResponse response=(HttpServletResponse)invocation.getArguments()[1];
      response.getOutputStream().write(content.getBytes());
      return null;
    }
  }
).when(mockDispatcher).include(Mockito.any(HttpServletRequest.class),Mockito.any(HttpServletResponse.class));
  assertEquals(content,IOUtils.toString(victim.getInputStream(mockRequest,mockResponse,"/static/*.js")));
  verify(mockUriLocator,never()).locate(Mockito.anyString());
}
