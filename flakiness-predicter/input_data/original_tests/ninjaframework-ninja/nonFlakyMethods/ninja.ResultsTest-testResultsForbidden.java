@Test public void testResultsForbidden(){
  Result result=Results.forbidden();
  assertEquals(Result.SC_403_FORBIDDEN,result.getStatusCode());
}
