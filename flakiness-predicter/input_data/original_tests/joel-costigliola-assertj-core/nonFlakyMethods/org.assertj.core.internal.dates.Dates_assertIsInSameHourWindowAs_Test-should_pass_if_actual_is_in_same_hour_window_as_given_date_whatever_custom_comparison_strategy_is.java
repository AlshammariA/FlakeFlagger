@Test public void should_pass_if_actual_is_in_same_hour_window_as_given_date_whatever_custom_comparison_strategy_is(){
  datesWithCustomComparisonStrategy.assertIsInSameHourWindowAs(someInfo(),actual,parseDatetime("2011-01-01T03:59:02"));
  datesWithCustomComparisonStrategy.assertIsInSameHourWindowAs(someInfo(),actual,parseDatetime("2011-01-01T04:01:00"));
}
