@Test public void should_create_Assert(){
  AbstractFloatArrayAssert<?> assertions=Assertions.assertThat(emptyArray());
  assertNotNull(assertions);
}
