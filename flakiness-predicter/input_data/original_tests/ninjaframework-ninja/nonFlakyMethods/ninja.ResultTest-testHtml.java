@Test public void testHtml(){
  Result result=new Result(Result.SC_200_OK);
  result.html();
  assertEquals(Result.TEXT_HTML,result.getContentType());
}
