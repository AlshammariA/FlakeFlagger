@Test public void should_pass_if_actual_is_within_given_second_whatever_custom_comparison_strategy_is(){
  datesWithCustomComparisonStrategy.assertIsWithinSecond(someInfo(),actual,17);
}
