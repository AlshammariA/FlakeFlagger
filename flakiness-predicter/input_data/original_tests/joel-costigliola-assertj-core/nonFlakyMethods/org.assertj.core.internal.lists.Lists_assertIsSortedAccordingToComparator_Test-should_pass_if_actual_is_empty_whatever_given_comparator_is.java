@Test public void should_pass_if_actual_is_empty_whatever_given_comparator_is(){
  lists.assertIsSortedAccordingToComparator(someInfo(),newArrayList(),stringDescendingOrderComparator);
  lists.assertIsSortedAccordingToComparator(someInfo(),newArrayList(),comparator);
}
