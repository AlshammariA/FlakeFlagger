@Test public void testUtf8IsUsedAsDefaultCharset(){
  Result result=new Result(Result.SC_200_OK);
  assertEquals("utf-8",result.getCharset());
}
