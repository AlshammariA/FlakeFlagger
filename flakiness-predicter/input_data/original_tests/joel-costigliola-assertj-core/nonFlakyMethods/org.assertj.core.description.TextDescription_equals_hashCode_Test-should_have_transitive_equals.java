@Test public void should_have_transitive_equals(){
  assertEqualsIsTransitive(description,new TextDescription("Yoda"),new TextDescription("Yoda"));
}
