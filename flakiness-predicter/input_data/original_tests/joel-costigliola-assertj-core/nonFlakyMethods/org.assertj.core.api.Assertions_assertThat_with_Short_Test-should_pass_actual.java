@Test public void should_pass_actual(){
  Short eight=(short)8;
  AbstractShortAssert<?> assertions=Assertions.assertThat(eight);
  assertThat(assertions.actual).isSameAs(eight);
}
