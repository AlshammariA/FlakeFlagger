@Test public void testParseBodyPostWorks(){
  when(httpServletRequest.getContentType()).thenReturn(ContentTypes.APPLICATION_POST_FORM);
  context.init(httpServletRequest,httpServletResponse);
  when(bodyParserEngineManager.getBodyParserEngineForContentType(ContentTypes.APPLICATION_POST_FORM)).thenReturn(bodyParserEngine);
  Dummy dummy=new Dummy();
  dummy.name="post";
  dummy.count=245L;
  when(bodyParserEngine.invoke(context,Dummy.class)).thenReturn(dummy);
  Dummy o=context.parseBody(Dummy.class);
  verify(bodyParserEngineManager).getBodyParserEngineForContentType(ContentTypes.APPLICATION_POST_FORM);
  assertTrue(o instanceof Dummy);
  assertTrue(o.name.equals(dummy.name));
  assertTrue(o.count.equals(dummy.count));
}
