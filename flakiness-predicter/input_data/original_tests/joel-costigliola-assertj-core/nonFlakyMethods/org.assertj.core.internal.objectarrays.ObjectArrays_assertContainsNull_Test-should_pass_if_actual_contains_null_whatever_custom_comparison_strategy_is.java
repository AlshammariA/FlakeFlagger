@Test public void should_pass_if_actual_contains_null_whatever_custom_comparison_strategy_is(){
  arraysWithCustomComparisonStrategy.assertContainsNull(someInfo(),actual);
}
