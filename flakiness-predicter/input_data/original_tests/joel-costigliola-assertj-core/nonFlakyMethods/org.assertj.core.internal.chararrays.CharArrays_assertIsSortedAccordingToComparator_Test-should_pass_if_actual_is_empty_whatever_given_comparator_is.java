@Test public void should_pass_if_actual_is_empty_whatever_given_comparator_is(){
  arrays.assertIsSortedAccordingToComparator(someInfo(),emptyArray(),charDescendingOrderComparator);
  arrays.assertIsSortedAccordingToComparator(someInfo(),emptyArray(),charAscendingOrderComparator);
}
