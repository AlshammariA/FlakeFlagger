@Test public void testResultsStatus(){
  Result result=Results.status(200);
  assertEquals(200,result.getStatusCode());
}
