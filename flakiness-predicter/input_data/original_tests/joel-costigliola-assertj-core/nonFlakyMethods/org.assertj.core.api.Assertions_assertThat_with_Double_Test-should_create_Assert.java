@Test public void should_create_Assert(){
  Double zero=0d;
  AbstractDoubleAssert<?> assertions=Assertions.assertThat(zero);
  assertThat(assertions).isNotNull();
}
