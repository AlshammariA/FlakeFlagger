@Test public void should_pass_if_actual_contains_given_values_only_more_than_once(){
  actual=arrayOf(6,8,10,8,8,8);
  arrays.assertContainsOnly(someInfo(),actual,arrayOf(6,8,10));
}
