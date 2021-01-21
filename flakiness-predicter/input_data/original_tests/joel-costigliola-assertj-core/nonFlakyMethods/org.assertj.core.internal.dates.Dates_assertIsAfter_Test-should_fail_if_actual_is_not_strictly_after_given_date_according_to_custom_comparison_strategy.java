@Test public void should_fail_if_actual_is_not_strictly_after_given_date_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2022-01-01");
  try {
    datesWithCustomComparisonStrategy.assertIsAfter(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAfter(actual,other,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
