@Test public void testGetAcceptEncoding(){
  String encoding="compress, gzip";
  when(httpServletRequest.getHeader("accept-encoding")).thenReturn(encoding);
  context.init(httpServletRequest,httpServletResponse);
  assertEquals(encoding,context.getAcceptEncoding());
  encoding=null;
  when(httpServletRequest.getHeader("accept-encoding")).thenReturn(encoding);
  context.init(httpServletRequest,httpServletResponse);
  assertNull(context.getAcceptEncoding());
  encoding="gzip;q=1.0, identity; q=0.5, *;q=0";
  when(httpServletRequest.getHeader("accept-encoding")).thenReturn(encoding);
  context.init(httpServletRequest,httpServletResponse);
  assertEquals(encoding,context.getAcceptEncoding());
}
