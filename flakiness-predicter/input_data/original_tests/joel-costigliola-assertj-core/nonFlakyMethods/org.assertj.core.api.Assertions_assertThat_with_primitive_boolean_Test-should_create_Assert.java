@Test public void should_create_Assert(){
  AbstractBooleanAssert<?> assertions=Assertions.assertThat(true);
  assertNotNull(assertions);
}
