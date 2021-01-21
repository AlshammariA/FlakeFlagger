@Test public void testRedirect(){
  Result result=new Result(Result.SC_200_OK);
  result.redirect("http://example.com");
  assertEquals(1,result.getHeaders().size());
  assertEquals("http://example.com",result.getHeaders().get(Result.LOCATION));
  assertEquals(Result.SC_303_SEE_OTHER,result.getStatusCode());
}
