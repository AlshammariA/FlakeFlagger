@Test public void should_pass_if_actual_and_sequence_are_equal(){
  arrays.assertEndsWith(someInfo(),actual,arrayOf(6d,8d,10d,12d));
}
