@Test public void should_fail_if_actual_is_not_strictly_before_given_year_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  int year=2010;
  try {
    datesWithCustomComparisonStrategy.assertIsBeforeYear(info,actual,year);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBeforeYear(actual,year));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
