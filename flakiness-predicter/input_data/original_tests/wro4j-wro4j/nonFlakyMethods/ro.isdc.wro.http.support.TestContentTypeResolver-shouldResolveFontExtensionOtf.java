@Test public void shouldResolveFontExtensionOtf(){
  assertEquals("application/x-font-opentype",ContentTypeResolver.get("font.otf"));
}
