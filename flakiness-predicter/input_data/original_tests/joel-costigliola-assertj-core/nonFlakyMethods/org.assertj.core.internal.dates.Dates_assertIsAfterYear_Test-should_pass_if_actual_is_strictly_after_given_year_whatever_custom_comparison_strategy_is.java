@Test public void should_pass_if_actual_is_strictly_after_given_year_whatever_custom_comparison_strategy_is(){
  datesWithCustomComparisonStrategy.assertIsAfterYear(someInfo(),actual,2000);
}
