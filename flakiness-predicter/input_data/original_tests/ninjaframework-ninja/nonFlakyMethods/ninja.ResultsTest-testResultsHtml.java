@Test public void testResultsHtml(){
  Result result=Results.html();
  assertEquals(Result.SC_200_OK,result.getStatusCode());
  assertEquals(Result.TEXT_HTML,result.getContentType());
}
