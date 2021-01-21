@Test public void testGetAcceptLanguage(){
  String language="de";
  when(httpServletRequest.getHeader("accept-language")).thenReturn(language);
  context.init(httpServletRequest,httpServletResponse);
  assertEquals(language,context.getAcceptLanguage());
  language=null;
  when(httpServletRequest.getHeader("accept-language")).thenReturn(language);
  context.init(httpServletRequest,httpServletResponse);
  assertNull(context.getAcceptLanguage());
  language="da, en-gb;q=0.8, en;q=0.7";
  when(httpServletRequest.getHeader("accept-language")).thenReturn(language);
  context.init(httpServletRequest,httpServletResponse);
  assertEquals(language,context.getAcceptLanguage());
}
