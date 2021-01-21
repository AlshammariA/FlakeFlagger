@Test public void should_fail_if_actual_is_not_in_same_day_as_given_date(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2011-01-02");
  try {
    dates.assertIsInSameDayAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameDay(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
