@Test public void testResultsXml(){
  Result result=Results.xml();
  assertEquals(Result.SC_200_OK,result.getStatusCode());
  assertEquals(Result.APPLICATION_XML,result.getContentType());
}
