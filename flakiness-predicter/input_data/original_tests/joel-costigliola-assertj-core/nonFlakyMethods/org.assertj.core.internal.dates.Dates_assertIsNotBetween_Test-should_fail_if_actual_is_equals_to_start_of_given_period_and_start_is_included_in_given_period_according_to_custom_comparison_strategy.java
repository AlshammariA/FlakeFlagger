@Test public void should_fail_if_actual_is_equals_to_start_of_given_period_and_start_is_included_in_given_period_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=parseDate("2011-09-15");
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-10-01");
  boolean inclusiveStart=true;
  boolean inclusiveEnd=false;
  try {
    datesWithCustomComparisonStrategy.assertIsNotBetween(info,actual,start,end,inclusiveStart,inclusiveEnd);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeBetween(actual,start,end,inclusiveStart,inclusiveEnd,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
