@Test public void should_pass_if_actual_and_sequence_are_empty(){
  actual.clear();
  iterables.assertStartsWith(someInfo(),actual,emptyArray());
}
