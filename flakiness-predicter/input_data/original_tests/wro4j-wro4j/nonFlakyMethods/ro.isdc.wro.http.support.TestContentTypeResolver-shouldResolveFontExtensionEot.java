@Test public void shouldResolveFontExtensionEot(){
  assertEquals("application/vnd.ms-fontobject",ContentTypeResolver.get("font.eot"));
}
