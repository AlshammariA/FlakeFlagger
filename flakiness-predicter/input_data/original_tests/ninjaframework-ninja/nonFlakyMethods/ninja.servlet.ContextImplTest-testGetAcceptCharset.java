@Test public void testGetAcceptCharset(){
  String charset="UTF-8";
  when(httpServletRequest.getHeader("accept-charset")).thenReturn(charset);
  context.init(httpServletRequest,httpServletResponse);
  assertEquals(charset,context.getAcceptCharset());
  charset=null;
  when(httpServletRequest.getHeader("accept-charset")).thenReturn(charset);
  context.init(httpServletRequest,httpServletResponse);
  assertNull(context.getAcceptCharset());
  charset="iso-8859-5, unicode-1-1;q=0.8";
  when(httpServletRequest.getHeader("accept-charset")).thenReturn(charset);
  context.init(httpServletRequest,httpServletResponse);
  assertEquals(charset,context.getAcceptCharset());
}
