@Test public void should_pass_actual(){
  String actual="Yoda";
  AbstractCharSequenceAssert<?,?> assertions=Assertions.assertThat((CharSequence)actual);
  assertSame(actual,assertions.actual);
}
