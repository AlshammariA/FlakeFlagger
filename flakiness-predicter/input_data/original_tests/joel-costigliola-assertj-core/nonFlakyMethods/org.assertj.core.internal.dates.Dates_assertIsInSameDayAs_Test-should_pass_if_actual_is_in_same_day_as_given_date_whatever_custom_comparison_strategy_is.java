@Test public void should_pass_if_actual_is_in_same_day_as_given_date_whatever_custom_comparison_strategy_is(){
  datesWithCustomComparisonStrategy.assertIsInSameDayAs(someInfo(),actual,parseDate("2011-01-01"));
}
