@Test public void should_create_Assert(){
  AbstractBigDecimalAssert<?> assertions=Assertions.assertThat(ZERO);
  assertThat(assertions).isNotNull();
}
