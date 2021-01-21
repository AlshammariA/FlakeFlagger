@Test public void should_fail_if_actual_is_not_in_same_hour_as_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T04:01:02");
  try {
    dates.assertIsInSameHourAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameHour(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
