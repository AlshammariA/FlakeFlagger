@Test public void should_pass_if_actual_is_equals_to_given_date_according_to_custom_comparison_strategy(){
  datesWithCustomComparisonStrategy.assertIsAfterOrEqualsTo(someInfo(),actual,parseDate("2011-01-31"));
}
