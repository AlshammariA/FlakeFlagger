@Test public void should_pass_if_actual_ends_with_sequence(){
  arrays.assertEndsWith(someInfo(),actual,array("Luke","Leia","Obi-Wan"));
}
