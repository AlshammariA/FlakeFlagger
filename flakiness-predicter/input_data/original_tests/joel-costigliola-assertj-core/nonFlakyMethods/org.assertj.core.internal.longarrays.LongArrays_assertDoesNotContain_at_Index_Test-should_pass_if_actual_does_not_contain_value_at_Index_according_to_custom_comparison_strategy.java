@Test public void should_pass_if_actual_does_not_contain_value_at_Index_according_to_custom_comparison_strategy(){
  arraysWithCustomComparisonStrategy.assertDoesNotContain(someInfo(),actual,6L,atIndex(1));
}
