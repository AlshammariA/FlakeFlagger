@Test public void testRedirectTemporary(){
  Result result=new Result(Result.SC_200_OK);
  result.redirectTemporary("http://example.com");
  assertEquals(1,result.getHeaders().size());
  assertEquals("http://example.com",result.getHeaders().get(Result.LOCATION));
  assertEquals(Result.SC_307_TEMPORARY_REDIRECT,result.getStatusCode());
}
