@Test public void should_pass_if_actual_is_sorted_according_to_given_comparator(){
  arrays.assertIsSortedAccordingToComparator(someInfo(),actual,doubleDescendingOrderComparator);
}
