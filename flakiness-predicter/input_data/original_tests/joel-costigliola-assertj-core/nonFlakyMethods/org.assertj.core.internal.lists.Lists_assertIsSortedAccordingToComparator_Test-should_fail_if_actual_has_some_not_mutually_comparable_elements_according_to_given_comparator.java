@Test public void should_fail_if_actual_has_some_not_mutually_comparable_elements_according_to_given_comparator(){
  AssertionInfo info=someInfo();
  List<Object> actual=newArrayList();
  actual.add("bar");
  actual.add(new Integer(5));
  actual.add("foo");
  try {
    lists.assertIsSortedAccordingToComparator(info,actual,stringDescendingOrderComparator);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveComparableElementsAccordingToGivenComparator(actual,stringDescendingOrderComparator));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
