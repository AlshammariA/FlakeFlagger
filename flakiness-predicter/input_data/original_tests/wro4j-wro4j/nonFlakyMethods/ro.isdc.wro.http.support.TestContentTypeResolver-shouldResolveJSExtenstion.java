@Test public void shouldResolveJSExtenstion(){
  assertEquals("application/javascript",ContentTypeResolver.get("/ad/df/mefile.js"));
}
