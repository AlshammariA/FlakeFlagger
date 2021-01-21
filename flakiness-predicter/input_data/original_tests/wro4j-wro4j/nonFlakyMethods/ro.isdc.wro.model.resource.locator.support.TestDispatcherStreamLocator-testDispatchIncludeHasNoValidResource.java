@Test(expected=IOException.class) public void testDispatchIncludeHasNoValidResource() throws Exception {
  when(mockRequest.getRequestDispatcher(Mockito.anyString())).thenReturn(mockDispatcher);
  doAnswer(new Answer<Void>(){
    public Void answer(    final InvocationOnMock invocation) throws Throwable {
      throw new IOException("Include doesn't work... nothing found");
    }
  }
).when(mockDispatcher).include(Mockito.any(HttpServletRequest.class),Mockito.any(HttpServletResponse.class));
  victim.getInputStream(mockRequest,mockResponse,"/static/*.js");
}
