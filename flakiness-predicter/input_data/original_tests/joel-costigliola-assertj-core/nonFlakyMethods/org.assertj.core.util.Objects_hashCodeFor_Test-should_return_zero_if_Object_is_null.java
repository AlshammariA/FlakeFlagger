@Test public void should_return_zero_if_Object_is_null(){
  assertThat(hashCodeFor(null)).isZero();
}
