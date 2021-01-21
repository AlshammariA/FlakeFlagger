@Test public void should_pass_if_actual_is_strictly_between_given_period_according_to_custom_comparison_strategy(){
  Date start=parseDate("2011-08-30");
  Date end=parseDate("2011-10-01");
  datesWithCustomComparisonStrategy.assertIsBetween(someInfo(),actual,start,end,false,false);
}
