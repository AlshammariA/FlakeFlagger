@Test public void should_create_Assert_with_StringBuffer(){
  AbstractCharSequenceAssert<?,?> assertions=Assertions.assertThat(new StringBuffer("Yoda"));
  assertNotNull(assertions);
}
