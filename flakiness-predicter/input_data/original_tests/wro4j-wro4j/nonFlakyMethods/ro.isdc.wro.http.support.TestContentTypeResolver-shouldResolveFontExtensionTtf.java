@Test public void shouldResolveFontExtensionTtf(){
  assertEquals("application/octet-stream",ContentTypeResolver.get("font.ttf"));
}
