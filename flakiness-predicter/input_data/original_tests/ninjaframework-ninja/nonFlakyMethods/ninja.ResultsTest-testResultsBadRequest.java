@Test public void testResultsBadRequest(){
  Result result=Results.badRequest();
  assertEquals(Result.SC_400_BAD_REQUEST,result.getStatusCode());
}
