@Test public void should_fail_if_actual_is_not_sorted_in_ascending_order_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=newArrayList("Luke","Yoda","Leia");
  try {
    listsWithCaseInsensitiveComparisonStrategy.assertIsSorted(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(1,actual,comparisonStrategy.getComparator()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
