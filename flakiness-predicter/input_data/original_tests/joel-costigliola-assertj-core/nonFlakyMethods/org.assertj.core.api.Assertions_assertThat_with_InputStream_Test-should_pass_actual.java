@Test public void should_pass_actual(){
  AbstractInputStreamAssert<?,? extends InputStream> assertions=Assertions.assertThat(actual);
  assertSame(actual,assertions.actual);
}
