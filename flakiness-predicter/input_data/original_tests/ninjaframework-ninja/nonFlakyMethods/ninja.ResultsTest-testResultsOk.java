@Test public void testResultsOk(){
  Result result=Results.ok();
  assertEquals(200,result.getStatusCode());
}
