@Test public void should_pass_if_actual_is_empty_whatever_custom_comparison_strategy_is(){
  arraysWithCustomComparisonStrategy.assertDoesNotContain(someInfo(),emptyArray(),(short)-8,someIndex());
}
