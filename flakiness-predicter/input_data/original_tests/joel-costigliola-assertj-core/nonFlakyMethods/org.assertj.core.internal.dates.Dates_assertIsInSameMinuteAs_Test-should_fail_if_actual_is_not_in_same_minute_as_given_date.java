@Test public void should_fail_if_actual_is_not_in_same_minute_as_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T03:14:02");
  try {
    dates.assertIsInSameMinuteAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameMinute(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
