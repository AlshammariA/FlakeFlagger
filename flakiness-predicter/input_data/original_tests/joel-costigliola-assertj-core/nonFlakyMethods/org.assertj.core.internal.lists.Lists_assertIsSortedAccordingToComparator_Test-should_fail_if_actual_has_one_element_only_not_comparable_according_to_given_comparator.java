@Test public void should_fail_if_actual_has_one_element_only_not_comparable_according_to_given_comparator(){
  AssertionInfo info=someInfo();
  List<Object> actual=newArrayList(new Object());
  try {
    lists.assertIsSortedAccordingToComparator(info,actual,stringDescendingOrderComparator);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveComparableElementsAccordingToGivenComparator(actual,stringDescendingOrderComparator));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
