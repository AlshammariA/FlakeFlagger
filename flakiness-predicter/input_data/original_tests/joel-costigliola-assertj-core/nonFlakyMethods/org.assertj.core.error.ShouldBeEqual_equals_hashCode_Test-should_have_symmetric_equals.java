@Test public void should_have_symmetric_equals(){
  assertEqualsIsSymmetric(factory,shouldBeEqual("Yoda","Luke",new StandardRepresentation()));
}
