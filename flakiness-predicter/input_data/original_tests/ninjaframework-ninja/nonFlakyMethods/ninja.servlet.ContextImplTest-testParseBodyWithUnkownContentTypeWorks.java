/** 
 * The request does not have the Content-Type set => we get a null response.
 */
@Test public void testParseBodyWithUnkownContentTypeWorks(){
  when(httpServletRequest.getContentType()).thenReturn(null);
  context.init(httpServletRequest,httpServletResponse);
  Object o=context.parseBody(Dummy.class);
  assertNull(o);
}
