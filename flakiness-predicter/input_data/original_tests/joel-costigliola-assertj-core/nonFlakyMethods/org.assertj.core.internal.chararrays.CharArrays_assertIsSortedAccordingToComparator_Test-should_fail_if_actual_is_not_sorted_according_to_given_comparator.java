@Test public void should_fail_if_actual_is_not_sorted_according_to_given_comparator(){
  AssertionInfo info=someInfo();
  actual=new char[]{'c','b','a','z'};
  try {
    arrays.assertIsSortedAccordingToComparator(info,actual,charDescendingOrderComparator);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(2,actual,charDescendingOrderComparator));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
