@Test public void should_pass_actual(){
  Integer eight=8;
  AbstractIntegerAssert<?> assertions=Assertions.assertThat(eight);
  assertThat(assertions.actual).isSameAs(eight);
}
