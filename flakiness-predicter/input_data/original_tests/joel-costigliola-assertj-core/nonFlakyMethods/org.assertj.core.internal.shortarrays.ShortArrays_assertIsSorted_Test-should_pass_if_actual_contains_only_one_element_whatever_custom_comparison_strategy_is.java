@Test public void should_pass_if_actual_contains_only_one_element_whatever_custom_comparison_strategy_is(){
  arraysWithCustomComparisonStrategy.assertIsSorted(someInfo(),arrayOf(1));
}
