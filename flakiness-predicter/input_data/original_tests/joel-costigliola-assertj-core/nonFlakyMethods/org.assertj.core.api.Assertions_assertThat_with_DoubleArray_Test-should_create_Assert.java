@Test public void should_create_Assert(){
  AbstractDoubleArrayAssert<?> assertions=Assertions.assertThat(emptyArray());
  assertNotNull(assertions);
}
