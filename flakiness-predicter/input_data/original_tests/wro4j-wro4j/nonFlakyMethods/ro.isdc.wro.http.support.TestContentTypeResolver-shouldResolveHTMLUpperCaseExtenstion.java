@Test public void shouldResolveHTMLUpperCaseExtenstion(){
  assertEquals("text/css",ContentTypeResolver.get("mefile.CSS"));
}
