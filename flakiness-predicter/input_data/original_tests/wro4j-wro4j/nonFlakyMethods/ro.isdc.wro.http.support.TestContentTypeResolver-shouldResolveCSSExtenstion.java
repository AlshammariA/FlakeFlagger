@Test public void shouldResolveCSSExtenstion(){
  assertEquals("text/css",ContentTypeResolver.get("somefile.css"));
}
