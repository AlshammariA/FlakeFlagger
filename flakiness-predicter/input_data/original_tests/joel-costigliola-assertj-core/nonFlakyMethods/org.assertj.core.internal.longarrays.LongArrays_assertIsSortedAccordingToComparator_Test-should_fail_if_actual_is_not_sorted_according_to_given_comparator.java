@Test public void should_fail_if_actual_is_not_sorted_according_to_given_comparator(){
  AssertionInfo info=someInfo();
  actual=new long[]{3L,2L,1L,9L};
  try {
    arrays.assertIsSortedAccordingToComparator(info,actual,longDescendingOrderComparator);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(2,actual,longDescendingOrderComparator));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
