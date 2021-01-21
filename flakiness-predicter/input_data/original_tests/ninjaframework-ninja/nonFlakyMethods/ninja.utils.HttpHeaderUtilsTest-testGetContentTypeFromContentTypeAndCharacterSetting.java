@Test public void testGetContentTypeFromContentTypeAndCharacterSetting(){
  assertEquals("application/json",HttpHeaderUtils.getContentTypeFromContentTypeAndCharacterSetting("application/json; charset=utf-8"));
  assertEquals("application/json",HttpHeaderUtils.getContentTypeFromContentTypeAndCharacterSetting("application/json"));
}
