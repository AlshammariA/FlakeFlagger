@Test public void should_pass_if_actual_contains_given_values_only_more_than_once(){
  actual=arrayOf(6d,8d,10d,8d,8d,8d);
  arrays.assertContainsOnly(someInfo(),actual,arrayOf(6d,8d,10d));
}
