@Test public void processValidModel() throws IOException {
  final HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
  final HttpServletResponse response=Mockito.mock(HttpServletResponse.class,Mockito.RETURNS_DEEP_STUBS);
  Mockito.when(request.getRequestURI()).thenReturn("/app/g1.css");
  Mockito.doAnswer(new Answer<Void>(){
    public Void answer(    final InvocationOnMock invocation) throws Throwable {
      LOG.debug("Header: {}",Arrays.toString(invocation.getArguments()));
      final Object[] arguments=invocation.getArguments();
      if (HttpHeader.ETAG.toString().equals(arguments[0])) {
        final String etagHeaderValue=(String)arguments[1];
        Assert.assertTrue(etagHeaderValue.matches("\".*?\""));
      }
      return null;
    }
  }
).when(response).setHeader(Mockito.anyString(),Mockito.anyString());
  Context.set(Context.webContext(request,response,Mockito.mock(FilterConfig.class)));
  managerFactory.create().process();
}
