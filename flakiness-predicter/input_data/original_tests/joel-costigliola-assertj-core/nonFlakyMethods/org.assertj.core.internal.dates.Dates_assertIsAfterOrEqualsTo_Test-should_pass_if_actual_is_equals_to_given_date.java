@Test public void should_pass_if_actual_is_equals_to_given_date(){
  dates.assertIsAfterOrEqualsTo(someInfo(),actual,parseDate("2011-01-01"));
}
