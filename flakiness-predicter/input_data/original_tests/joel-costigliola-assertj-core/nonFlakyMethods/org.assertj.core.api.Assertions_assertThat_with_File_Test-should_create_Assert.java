@Test public void should_create_Assert(){
  AbstractFileAssert<?> assertions=Assertions.assertThat(actual);
  assertNotNull(assertions);
}
