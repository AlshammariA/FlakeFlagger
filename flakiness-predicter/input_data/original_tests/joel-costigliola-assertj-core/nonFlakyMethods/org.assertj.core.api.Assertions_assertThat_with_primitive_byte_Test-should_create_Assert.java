@Test public void should_create_Assert(){
  AbstractByteAssert<?> assertions=Assertions.assertThat((byte)0);
  assertNotNull(assertions);
}
