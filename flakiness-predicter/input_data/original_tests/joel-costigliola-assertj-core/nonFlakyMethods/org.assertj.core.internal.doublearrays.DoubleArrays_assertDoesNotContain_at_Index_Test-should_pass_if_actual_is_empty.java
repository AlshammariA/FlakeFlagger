@Test public void should_pass_if_actual_is_empty(){
  arrays.assertDoesNotContain(someInfo(),emptyArray(),8d,someIndex());
}
