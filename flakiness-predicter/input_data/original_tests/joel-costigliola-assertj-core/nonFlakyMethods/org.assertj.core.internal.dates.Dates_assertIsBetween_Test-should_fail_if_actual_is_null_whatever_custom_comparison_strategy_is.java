@Test public void should_fail_if_actual_is_null_whatever_custom_comparison_strategy_is(){
  thrown.expectAssertionError(actualIsNull());
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-09-30");
  datesWithCustomComparisonStrategy.assertIsBetween(someInfo(),null,start,end,true,true);
}
