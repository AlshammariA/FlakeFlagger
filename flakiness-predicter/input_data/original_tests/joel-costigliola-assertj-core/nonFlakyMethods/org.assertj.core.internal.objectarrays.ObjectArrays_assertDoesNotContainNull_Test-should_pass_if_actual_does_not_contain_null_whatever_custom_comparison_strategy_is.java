@Test public void should_pass_if_actual_does_not_contain_null_whatever_custom_comparison_strategy_is(){
  arraysWithCustomComparisonStrategy.assertDoesNotContainNull(someInfo(),actual);
}
