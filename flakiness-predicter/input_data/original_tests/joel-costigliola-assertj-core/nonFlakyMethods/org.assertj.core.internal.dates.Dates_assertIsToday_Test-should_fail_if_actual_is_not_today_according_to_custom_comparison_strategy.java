@Test public void should_fail_if_actual_is_not_today_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    actual=parseDate("2111-01-01");
    datesWithCustomComparisonStrategy.assertIsToday(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeToday(actual,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
