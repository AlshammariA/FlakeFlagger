@Test public void testResultsHtmlWithStatusCode(){
  Result result=Results.html().status(Result.SC_300_MULTIPLE_CHOICES);
  assertEquals(Result.SC_300_MULTIPLE_CHOICES,result.getStatusCode());
  assertEquals(Result.TEXT_HTML,result.getContentType());
}
