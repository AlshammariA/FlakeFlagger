@Test public void should_create_Assert(){
  AbstractCharSequenceAssert<?,?> assertions=Assertions.assertThat("Yoda");
  assertNotNull(assertions);
}
