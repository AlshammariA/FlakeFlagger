@Test public void should_pass_actual(){
  Float eight=8f;
  AbstractFloatAssert<?> assertions=assertThat(eight);
  assertThat(assertions.actual).isSameAs(eight);
}
