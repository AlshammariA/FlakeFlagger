@Test public void should_pass_if_actual_contains_given_values_only_in_different_order(){
  arrays.assertContainsOnly(someInfo(),actual,arrayOf(10d,8d,6d));
}
