@Test public void should_pass_actual(){
  Byte eight=8;
  AbstractByteAssert<?> assertions=Assertions.assertThat(eight);
  assertThat(assertions.actual).isSameAs(eight);
}
