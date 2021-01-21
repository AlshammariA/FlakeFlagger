@Test public void should_fail_if_actual_is_not_strictly_before_given_date_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Date other=parseDate("2000-01-01");
  try {
    datesWithCustomComparisonStrategy.assertIsBefore(info,actual,other);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBefore(actual,other,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
