@Test public void should_fail_if_actual_is_empty_whatever_custom_comparison_strategy_is(){
  thrown.expectAssertionError(actualIsEmpty());
  arraysWithCustomComparisonStrategy.assertContains(someInfo(),emptyArray(),(byte)-8,someIndex());
}
