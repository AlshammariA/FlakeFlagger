@Test public void should_pass_actual(){
  AbstractBigDecimalAssert<?> assertions=Assertions.assertThat(ONE);
  assertThat(assertions.actual).isSameAs(ONE);
}
