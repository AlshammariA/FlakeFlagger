@Test public void should_pass_actual(){
  Long eight=8L;
  AbstractLongAssert<?> assertions=Assertions.assertThat(eight);
  assertThat(assertions.actual).isSameAs(eight);
}
