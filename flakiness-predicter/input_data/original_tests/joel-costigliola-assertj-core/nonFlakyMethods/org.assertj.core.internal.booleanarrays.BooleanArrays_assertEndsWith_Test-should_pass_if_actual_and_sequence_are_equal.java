@Test public void should_pass_if_actual_and_sequence_are_equal(){
  arrays.assertEndsWith(someInfo(),actual,arrayOf(true,false,false,true));
}
