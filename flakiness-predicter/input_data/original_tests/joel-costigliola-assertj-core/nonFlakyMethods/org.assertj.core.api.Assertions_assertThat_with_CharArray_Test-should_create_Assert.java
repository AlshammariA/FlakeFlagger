@Test public void should_create_Assert(){
  AbstractCharArrayAssert<?> assertions=Assertions.assertThat(emptyArray());
  assertNotNull(assertions);
}
