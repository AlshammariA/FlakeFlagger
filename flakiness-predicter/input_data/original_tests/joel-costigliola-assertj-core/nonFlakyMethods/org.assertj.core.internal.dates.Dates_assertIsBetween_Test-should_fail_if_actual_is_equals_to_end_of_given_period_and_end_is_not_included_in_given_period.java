@Test public void should_fail_if_actual_is_equals_to_end_of_given_period_and_end_is_not_included_in_given_period(){
  AssertionInfo info=someInfo();
  actual=parseDate("2011-09-30");
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-09-30");
  boolean inclusiveStart=true;
  boolean inclusiveEnd=false;
  try {
    dates.assertIsBetween(info,actual,start,end,inclusiveStart,inclusiveEnd);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(actual,start,end,inclusiveStart,inclusiveEnd));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
