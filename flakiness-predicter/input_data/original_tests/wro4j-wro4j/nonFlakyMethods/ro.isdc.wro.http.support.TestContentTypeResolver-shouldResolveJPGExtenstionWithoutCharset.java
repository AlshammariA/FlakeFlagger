@Test public void shouldResolveJPGExtenstionWithoutCharset(){
  assertEquals("image/jpeg",ContentTypeResolver.get("s/bvews/omefile.jpg","UTF-8"));
}
