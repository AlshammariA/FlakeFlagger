@Test public void should_create_Assert(){
  AbstractInputStreamAssert<?,? extends InputStream> assertions=Assertions.assertThat(actual);
  assertNotNull(assertions);
}
