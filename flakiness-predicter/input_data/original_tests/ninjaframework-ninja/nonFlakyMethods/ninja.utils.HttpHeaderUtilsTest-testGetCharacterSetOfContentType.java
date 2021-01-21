@Test public void testGetCharacterSetOfContentType(){
  assertEquals("utf-8",HttpHeaderUtils.getCharsetOfContentType("application/json; charset=utf-8","TEST_ENCODING"));
  assertEquals("utf-8",HttpHeaderUtils.getCharsetOfContentType("application/json;charset=utf-8","TEST_ENCODING"));
  assertEquals("TEST_ENCODING",HttpHeaderUtils.getCharsetOfContentType("application/json","TEST_ENCODING"));
}
