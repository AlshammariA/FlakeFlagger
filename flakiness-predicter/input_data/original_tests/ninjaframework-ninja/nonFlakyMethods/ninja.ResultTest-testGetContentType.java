@Test public void testGetContentType(){
  Result result=new Result(200);
  result.contentType("text/my-funky-content-type");
  assertEquals("text/my-funky-content-type",result.getContentType());
}
