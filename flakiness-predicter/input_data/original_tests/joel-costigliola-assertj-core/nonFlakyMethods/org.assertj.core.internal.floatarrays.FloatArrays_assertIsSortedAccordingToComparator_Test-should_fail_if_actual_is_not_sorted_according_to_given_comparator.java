@Test public void should_fail_if_actual_is_not_sorted_according_to_given_comparator(){
  AssertionInfo info=someInfo();
  actual=new float[]{3.0f,2.0f,1.0f,9.0f};
  try {
    arrays.assertIsSortedAccordingToComparator(info,actual,floatDescendingOrderComparator);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSortedAccordingToGivenComparator(2,actual,floatDescendingOrderComparator));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
