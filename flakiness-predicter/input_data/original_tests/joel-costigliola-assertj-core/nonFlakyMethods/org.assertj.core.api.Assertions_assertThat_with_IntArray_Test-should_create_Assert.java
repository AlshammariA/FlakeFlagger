@Test public void should_create_Assert(){
  AbstractIntArrayAssert<?> assertions=Assertions.assertThat(emptyArray());
  assertNotNull(assertions);
}
