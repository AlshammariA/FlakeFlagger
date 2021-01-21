@Test public void should_fail_if_actual_is_not_between_given_period_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=parseDate("2011-10-01");
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-09-30");
  boolean inclusiveStart=true;
  boolean inclusiveEnd=true;
  try {
    datesWithCustomComparisonStrategy.assertIsBetween(info,actual,start,end,inclusiveStart,inclusiveEnd);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(actual,start,end,inclusiveStart,inclusiveEnd,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
