@Test public void should_pass_if_actual_and_sequence_are_equal(){
  arrays.assertStartsWith(someInfo(),actual,arrayOf(6L,8L,10L,12L));
}
