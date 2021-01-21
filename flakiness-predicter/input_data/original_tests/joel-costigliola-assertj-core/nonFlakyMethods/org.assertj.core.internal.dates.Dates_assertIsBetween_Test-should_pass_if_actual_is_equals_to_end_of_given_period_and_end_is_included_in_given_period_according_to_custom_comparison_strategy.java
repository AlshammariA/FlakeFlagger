@Test public void should_pass_if_actual_is_equals_to_end_of_given_period_and_end_is_included_in_given_period_according_to_custom_comparison_strategy(){
  actual=parseDate("2011-09-15");
  Date start=parseDate("2011-08-30");
  Date end=parseDate("2011-09-30");
  datesWithCustomComparisonStrategy.assertIsBetween(someInfo(),actual,start,end,false,true);
  datesWithCustomComparisonStrategy.assertIsBetween(someInfo(),actual,start,end,true,true);
}
