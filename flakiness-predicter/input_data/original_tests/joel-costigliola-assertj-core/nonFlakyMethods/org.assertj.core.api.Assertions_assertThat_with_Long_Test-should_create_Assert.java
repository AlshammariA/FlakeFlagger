@Test public void should_create_Assert(){
  Long zero=0L;
  AbstractLongAssert<?> assertions=Assertions.assertThat(zero);
  assertThat(assertions).isNotNull();
}
