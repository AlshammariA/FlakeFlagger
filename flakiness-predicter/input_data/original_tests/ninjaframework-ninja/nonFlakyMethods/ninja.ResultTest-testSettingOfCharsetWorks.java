@Test public void testSettingOfCharsetWorks(){
  Result result=new Result(Result.SC_200_OK);
  result.charset("iso-7777");
  assertEquals("iso-7777",result.getCharset());
}
