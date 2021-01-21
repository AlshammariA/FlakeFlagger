@Test public void testContentNegotiation(){
  when(context.getAcceptContentType()).thenReturn("text/html");
  Result result=Results.ok();
  resultHandler.handleResult(result,context);
  assertEquals("text/html",result.getContentType());
  verify(templateEngineHtml).invoke(context,result);
}
