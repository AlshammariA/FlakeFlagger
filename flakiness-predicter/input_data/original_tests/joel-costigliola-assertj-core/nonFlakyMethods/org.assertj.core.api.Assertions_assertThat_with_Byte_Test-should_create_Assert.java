@Test public void should_create_Assert(){
  Byte zero=0;
  AbstractByteAssert<?> assertions=Assertions.assertThat(zero);
  assertThat(assertions).isNotNull();
}
