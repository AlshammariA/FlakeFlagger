@Test public void should_pass_if_actual_contains_given_values_only(){
  arrays.assertContainsOnlyOnce(someInfo(),actual,arrayOf(true,false));
}
