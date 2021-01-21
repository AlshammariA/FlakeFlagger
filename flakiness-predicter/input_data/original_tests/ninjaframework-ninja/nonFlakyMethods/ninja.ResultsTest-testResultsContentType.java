@Test public void testResultsContentType(){
  Result result=Results.contentType("text/my-cool-content-type");
  assertEquals(Result.SC_200_OK,result.getStatusCode());
  assertEquals("text/my-cool-content-type",result.getContentType());
}
