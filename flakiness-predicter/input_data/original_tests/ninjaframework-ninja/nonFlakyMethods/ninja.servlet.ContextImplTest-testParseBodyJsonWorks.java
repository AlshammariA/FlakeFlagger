/** 
 * This is the default mode. We get a Content-Type: application/json and want to parse the incoming json.
 */
@Test public void testParseBodyJsonWorks(){
  when(httpServletRequest.getContentType()).thenReturn("application/json; charset=utf-8");
  context.init(httpServletRequest,httpServletResponse);
  when(bodyParserEngineManager.getBodyParserEngineForContentType("application/json")).thenReturn(bodyParserEngine);
  when(bodyParserEngine.invoke(context,Dummy.class)).thenReturn(new Dummy());
  Object o=context.parseBody(Dummy.class);
  verify(bodyParserEngineManager).getBodyParserEngineForContentType("application/json");
  assertTrue(o instanceof Dummy);
}
