@Test public void should_pass_actual(){
  Double eight=8d;
  AbstractDoubleAssert<?> assertions=Assertions.assertThat(eight);
  assertThat(assertions.actual).isSameAs(eight);
}
