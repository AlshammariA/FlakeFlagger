@Test public void should_create_Assert(){
  Integer zero=0;
  AbstractIntegerAssert<?> assertions=Assertions.assertThat(zero);
  assertThat(assertions).isNotNull();
}
