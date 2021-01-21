@Test public void should_fail_if_actual_is_not_in_the_future_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    datesWithCustomComparisonStrategy.assertIsInTheFuture(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeInTheFuture(actual,yearAndMonthComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
