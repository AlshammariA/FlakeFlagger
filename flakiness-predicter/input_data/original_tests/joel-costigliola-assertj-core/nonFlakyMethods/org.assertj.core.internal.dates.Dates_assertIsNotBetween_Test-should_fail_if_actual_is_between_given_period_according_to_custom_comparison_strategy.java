@Test public void should_fail_if_actual_is_between_given_period_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Date start=parseDate("2011-08-31");
  Date end=parseDate("2011-09-30");
  boolean inclusiveStart=true;
  boolean inclusiveEnd=true;
  try {
    datesWithCustomComparisonStrategy.assertIsNotBetween(info,actual,start,end,inclusiveStart,inclusiveEnd);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeBetween(actual,start,end,inclusiveStart,inclusiveEnd,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
