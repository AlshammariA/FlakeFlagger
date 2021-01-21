@Test public void should_fail_if_actual_is_not_sorted_in_ascending_order_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=arrayOf(1,3,2);
  try {
    arraysWithCustomComparisonStrategy.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(1,actual,comparatorForCustomComparisonStrategy()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
