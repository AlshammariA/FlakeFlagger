@Test public void shouldResolveJPGExtenstion(){
  assertEquals("image/jpeg",ContentTypeResolver.get("s/bvews/omefile.jpg"));
}
