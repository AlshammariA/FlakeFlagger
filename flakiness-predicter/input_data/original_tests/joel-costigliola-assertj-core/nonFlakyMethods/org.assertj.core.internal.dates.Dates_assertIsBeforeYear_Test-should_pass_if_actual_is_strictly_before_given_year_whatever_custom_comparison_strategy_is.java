@Test public void should_pass_if_actual_is_strictly_before_given_year_whatever_custom_comparison_strategy_is(){
  datesWithCustomComparisonStrategy.assertIsBeforeYear(someInfo(),actual,2020);
}
