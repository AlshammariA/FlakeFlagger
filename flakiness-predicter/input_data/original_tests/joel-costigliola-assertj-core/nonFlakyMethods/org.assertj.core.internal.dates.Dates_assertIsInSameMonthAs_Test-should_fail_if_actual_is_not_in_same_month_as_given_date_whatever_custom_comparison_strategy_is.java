@Test public void should_fail_if_actual_is_not_in_same_month_as_given_date_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2011-02-01");
  try {
    datesWithCustomComparisonStrategy.assertIsInSameMonthAs(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInSameMonth(actual,other));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
