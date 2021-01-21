@Test public void should_fail_if_actual_is_not_sorted_according_to_given_comparator(){
  AssertionInfo info=someInfo();
  actual=new byte[]{3,2,1,9};
  try {
    arrays.assertIsSortedAccordingToComparator(info,actual,byteDescendingOrderComparator);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(2,actual,byteDescendingOrderComparator));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
