@Test public void should_create_Assert(){
  Float zero=0f;
  AbstractFloatAssert<?> assertions=assertThat(zero);
  assertThat(assertions).isNotNull();
}
