@Test public void should_pass_actual(){
  double[] actual=emptyArray();
  AbstractDoubleArrayAssert<?> assertions=Assertions.assertThat(actual);
  assertSame(actual,assertions.actual);
}
