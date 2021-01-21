@Test public void should_fail_if_actual_is_equals_to_given_date_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2011-01-31");
  try {
    datesWithCustomComparisonStrategy.assertIsAfter(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeAfter(actual,other,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
