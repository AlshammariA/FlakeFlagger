@Test public void shouldOnlyUseLastDot(){
  assertEquals("image/png",ContentTypeResolver.get("somefile.js.png"));
}
