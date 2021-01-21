@Test public void should_pass_if_actual_is_in_same_second_as_given_date_whatever_custom_comparison_strategy_is(){
  Date other=parseDatetime("2011-01-01T03:15:05");
  datesWithCustomComparisonStrategy.assertIsInSameSecondAs(someInfo(),actual,other);
  datesWithCustomComparisonStrategy.assertIsInSameSecondAs(someInfo(),actual,new Date(other.getTime() + 999));
}
