@Test public void should_create_Assert(){
  Short zero=(short)0;
  AbstractShortAssert<?> assertions=Assertions.assertThat(zero);
  assertThat(assertions).isNotNull();
}
