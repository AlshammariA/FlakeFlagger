@Test public void should_create_Assert(){
  AbstractShortArrayAssert<?> assertions=Assertions.assertThat(emptyArray());
  assertNotNull(assertions);
}
