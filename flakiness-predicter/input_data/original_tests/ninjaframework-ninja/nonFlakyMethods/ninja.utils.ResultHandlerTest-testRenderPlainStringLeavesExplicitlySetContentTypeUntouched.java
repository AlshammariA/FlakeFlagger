@Test public void testRenderPlainStringLeavesExplicitlySetContentTypeUntouched(){
  final String toRender="this is just a plain string";
  final String contentType="any/contenttype";
  Result result=Results.ok();
  result.contentType(contentType);
  result.render(toRender);
  resultHandler.handleResult(result,context);
  assertEquals(contentType,result.getContentType());
}
