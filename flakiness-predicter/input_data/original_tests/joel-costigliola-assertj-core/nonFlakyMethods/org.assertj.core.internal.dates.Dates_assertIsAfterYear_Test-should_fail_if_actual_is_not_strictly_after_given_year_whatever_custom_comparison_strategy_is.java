@Test public void should_fail_if_actual_is_not_strictly_after_given_year_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  int year=2020;
  try {
    datesWithCustomComparisonStrategy.assertIsAfterYear(info,actual,year);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAfterYear(actual,year));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
