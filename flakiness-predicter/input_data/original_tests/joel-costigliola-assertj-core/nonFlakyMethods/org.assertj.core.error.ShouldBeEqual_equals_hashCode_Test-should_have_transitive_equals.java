@Test public void should_have_transitive_equals(){
  assertEqualsIsTransitive(factory,shouldBeEqual("Yoda","Luke",new StandardRepresentation()),shouldBeEqual("Yoda","Luke",new StandardRepresentation()));
}
