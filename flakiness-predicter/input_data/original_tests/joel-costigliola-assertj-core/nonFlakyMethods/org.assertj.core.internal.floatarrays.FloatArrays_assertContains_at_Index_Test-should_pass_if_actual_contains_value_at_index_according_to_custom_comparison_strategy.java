@Test public void should_pass_if_actual_contains_value_at_index_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertContains(someInfo(),actual,-8f,atIndex(1));
}
