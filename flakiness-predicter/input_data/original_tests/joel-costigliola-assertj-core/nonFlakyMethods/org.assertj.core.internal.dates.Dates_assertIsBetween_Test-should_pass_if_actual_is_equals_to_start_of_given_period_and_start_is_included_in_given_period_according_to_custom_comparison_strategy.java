@Test public void should_pass_if_actual_is_equals_to_start_of_given_period_and_start_is_included_in_given_period_according_to_custom_comparison_strategy(){
  actual=parseDate("2011-09-01");
  Date start=parseDate("2011-09-10");
  Date end=parseDate("2011-10-01");
  datesWithCustomComparisonStrategy.assertIsBetween(someInfo(),actual,start,end,true,false);
  datesWithCustomComparisonStrategy.assertIsBetween(someInfo(),actual,start,end,true,true);
}
