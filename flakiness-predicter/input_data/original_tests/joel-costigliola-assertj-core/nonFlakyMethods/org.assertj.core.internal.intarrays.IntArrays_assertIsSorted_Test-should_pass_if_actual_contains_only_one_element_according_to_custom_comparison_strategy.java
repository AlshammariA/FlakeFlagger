@Test public void should_pass_if_actual_contains_only_one_element_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertIsSorted(someInfo(),arrayOf(1));
}
