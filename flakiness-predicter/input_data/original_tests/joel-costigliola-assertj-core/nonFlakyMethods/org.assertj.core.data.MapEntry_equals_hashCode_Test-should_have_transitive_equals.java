@Test public void should_have_transitive_equals(){
  assertEqualsIsTransitive(entry,entry("key","value"),entry("key","value"));
}
