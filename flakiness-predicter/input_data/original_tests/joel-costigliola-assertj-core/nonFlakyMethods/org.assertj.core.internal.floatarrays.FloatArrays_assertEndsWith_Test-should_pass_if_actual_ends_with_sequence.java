@Test public void should_pass_if_actual_ends_with_sequence(){
  arrays.assertEndsWith(someInfo(),actual,arrayOf(8f,10f,12f));
}
