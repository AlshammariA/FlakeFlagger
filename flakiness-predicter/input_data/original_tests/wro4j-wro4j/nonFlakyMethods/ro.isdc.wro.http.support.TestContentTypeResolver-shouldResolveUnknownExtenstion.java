@Test public void shouldResolveUnknownExtenstion(){
  assertEquals("application/octet-stream",ContentTypeResolver.get("/ad/df/mefile.unknown"));
}
