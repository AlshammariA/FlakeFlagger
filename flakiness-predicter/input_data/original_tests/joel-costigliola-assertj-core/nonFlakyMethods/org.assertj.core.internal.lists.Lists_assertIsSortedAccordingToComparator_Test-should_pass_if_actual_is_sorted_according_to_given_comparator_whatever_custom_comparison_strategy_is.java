@Test public void should_pass_if_actual_is_sorted_according_to_given_comparator_whatever_custom_comparison_strategy_is(){
  listsWithCaseInsensitiveComparisonStrategy.assertIsSortedAccordingToComparator(someInfo(),newArrayList("Yoda","Vador","Luke","Leia","Leia"),stringDescendingOrderComparator);
}
