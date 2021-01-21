@Test public void should_fail_if_actual_is_not_in_same_hour_window_as_given_date_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  Date other=parseDatetime("2011-01-01T04:01:03");
  try {
    datesWithCustomComparisonStrategy.assertIsInSameHourWindowAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameHourWindow(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
