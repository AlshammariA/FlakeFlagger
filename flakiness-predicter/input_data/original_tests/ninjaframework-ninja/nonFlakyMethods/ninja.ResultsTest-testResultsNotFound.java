@Test public void testResultsNotFound(){
  Result result=Results.notFound();
  assertEquals(Result.SC_404_NOT_FOUND,result.getStatusCode());
}
