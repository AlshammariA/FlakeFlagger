@Test public void shouldResolveHTMLExtenstion(){
  assertEquals("text/html",ContentTypeResolver.get("mefile.html"));
}
