@Test public void testRenderPictureFromBytes(){
  final byte[] toRender=new byte[]{1,2,3};
  final String contentType="image/png";
  Result result=Results.ok();
  result.contentType(contentType);
  result.render(toRender);
  resultHandler.handleResult(result,context);
  assertEquals(contentType,result.getContentType());
}
