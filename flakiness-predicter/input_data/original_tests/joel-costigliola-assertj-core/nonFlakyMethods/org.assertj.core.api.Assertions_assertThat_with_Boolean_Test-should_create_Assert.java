@Test public void should_create_Assert(){
  AbstractBooleanAssert<?> assertions=Assertions.assertThat(TRUE);
  assertNotNull(assertions);
}
