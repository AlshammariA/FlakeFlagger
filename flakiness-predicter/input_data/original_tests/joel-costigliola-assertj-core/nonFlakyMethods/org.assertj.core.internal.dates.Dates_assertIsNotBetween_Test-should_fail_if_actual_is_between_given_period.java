@Test public void should_fail_if_actual_is_between_given_period(){
  AssertionInfo info=someInfo();
  Date start=parseDate("2011-09-01");
  Date end=parseDate("2011-09-30");
  boolean inclusiveStart=true;
  boolean inclusiveEnd=true;
  try {
    dates.assertIsNotBetween(info,actual,start,end,inclusiveStart,inclusiveEnd);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeBetween(actual,start,end,inclusiveStart,inclusiveEnd));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
