@Test public void should_pass_if_actual_is_close_to_given_date_by_less_than_given_delta_whatever_custom_comparison_strategy_is(){
  datesWithCustomComparisonStrategy.assertIsCloseTo(someInfo(),actual,parseDatetime("2011-01-01T03:15:05"),delta);
}
