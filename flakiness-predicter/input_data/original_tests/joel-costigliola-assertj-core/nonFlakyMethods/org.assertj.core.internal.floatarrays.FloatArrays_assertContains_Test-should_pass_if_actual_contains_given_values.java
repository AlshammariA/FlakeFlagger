@Test public void should_pass_if_actual_contains_given_values(){
  arrays.assertContains(someInfo(),actual,arrayOf(6f));
}
