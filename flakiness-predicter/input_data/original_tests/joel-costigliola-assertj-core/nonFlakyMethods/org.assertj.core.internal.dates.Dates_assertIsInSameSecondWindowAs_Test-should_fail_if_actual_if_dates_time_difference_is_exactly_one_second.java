@Test public void should_fail_if_actual_if_dates_time_difference_is_exactly_one_second(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T03:15:06");
  try {
    dates.assertIsInSameSecondWindowAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameSecondWindow(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
