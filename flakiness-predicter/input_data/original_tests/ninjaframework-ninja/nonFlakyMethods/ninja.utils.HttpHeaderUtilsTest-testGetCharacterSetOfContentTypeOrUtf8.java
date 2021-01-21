@Test public void testGetCharacterSetOfContentTypeOrUtf8(){
  assertEquals("TEST_ENCODING",HttpHeaderUtils.getCharsetOfContentType("application/json; charset=TEST_ENCODING",NinjaConstant.UTF_8));
  assertEquals("TEST_ENCODING",HttpHeaderUtils.getCharsetOfContentType("application/json;charset=TEST_ENCODING","TEST_ENCODING"));
  assertEquals(NinjaConstant.UTF_8,HttpHeaderUtils.getCharsetOfContentType("application/json",NinjaConstant.UTF_8));
}
