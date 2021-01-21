@Test public void should_fail_if_actual_is_not_in_same_hour_as_given_date_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T04:01:02");
  try {
    datesWithCustomComparisonStrategy.assertIsInSameHourAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameHour(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
