@Test public void should_fail_if_actual_year_is_equals_to_given_year_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  parseDate("2011-01-01");
  int year=2011;
  try {
    datesWithCustomComparisonStrategy.assertIsBeforeYear(info,actual,year);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBeforeYear(actual,year));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
