@Test public void testUnsetCookie(){
  Result result=new Result(200);
  result.unsetCookie("Cookie-to-be-unset");
  assertEquals(1,result.getCookies().size());
  assertEquals("Cookie-to-be-unset",result.getCookies().get(0).getName());
  assertEquals("",result.getCookies().get(0).getValue());
}
