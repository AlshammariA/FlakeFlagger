@Test public void should_pass_if_actual_contains_given_values_only(){
  arrays.assertContainsOnly(someInfo(),actual,arrayOf(6,8,10));
}
