@Test public void testResultsInternalServerError(){
  Result result=Results.internalServerError();
  assertEquals(Result.SC_500_INTERNAL_SERVER_ERROR,result.getStatusCode());
}
