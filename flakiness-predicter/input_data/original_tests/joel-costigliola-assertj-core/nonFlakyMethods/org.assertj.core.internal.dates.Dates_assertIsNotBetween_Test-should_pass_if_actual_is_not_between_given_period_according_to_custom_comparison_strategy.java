@Test public void should_pass_if_actual_is_not_between_given_period_according_to_custom_comparison_strategy(){
  actual=parseDate("2011-12-31");
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-11-30");
  datesWithCustomComparisonStrategy.assertIsNotBetween(someInfo(),actual,start,end,true,true);
}
