@Test public void shouldResolveHTMLExtenstionWitCharset(){
  assertEquals("text/html; charset=UTF-8",ContentTypeResolver.get("mefile.html","UTF-8"));
}
