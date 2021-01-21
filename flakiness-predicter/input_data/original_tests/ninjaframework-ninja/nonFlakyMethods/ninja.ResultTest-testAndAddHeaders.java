@Test public void testAndAddHeaders(){
  Result result=new Result(200);
  result.addHeader("header1","value1");
  result.addHeader("header2","value2");
  assertEquals(2,result.getHeaders().size());
  assertEquals("value1",result.getHeaders().get("header1"));
  assertEquals("value2",result.getHeaders().get("header2"));
}
