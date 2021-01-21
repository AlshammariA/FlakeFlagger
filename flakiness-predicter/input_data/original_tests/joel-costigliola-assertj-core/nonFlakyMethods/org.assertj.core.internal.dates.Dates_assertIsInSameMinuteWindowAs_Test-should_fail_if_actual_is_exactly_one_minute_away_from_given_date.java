@Test public void should_fail_if_actual_is_exactly_one_minute_away_from_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T03:16:00");
  try {
    dates.assertIsInSameMinuteWindowAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameMinuteWindow(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
