@Test public void should_fail_if_time_difference_is_exactly_one_hour(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T04:01:02");
  try {
    dates.assertIsInSameHourWindowAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameHourWindow(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
