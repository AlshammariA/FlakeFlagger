@Test public void should_pass_if_actual_is_strictly_after_given_date_according_to_custom_comparison_strategy(){
  datesWithCustomComparisonStrategy.assertIsAfter(someInfo(),actual,parseDate("2000-01-01"));
}
