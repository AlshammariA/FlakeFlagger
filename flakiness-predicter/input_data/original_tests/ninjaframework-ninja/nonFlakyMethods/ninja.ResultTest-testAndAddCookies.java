@Test public void testAndAddCookies(){
  Result result=new Result(200);
  result.addCookie(Cookie.builder("cookie1","value1").build());
  result.addCookie(Cookie.builder("cookie2","value2").build());
  assertEquals(2,result.getCookies().size());
  assertEquals("value1",result.getCookies().get(0).getValue());
  assertEquals("value2",result.getCookies().get(1).getValue());
}
