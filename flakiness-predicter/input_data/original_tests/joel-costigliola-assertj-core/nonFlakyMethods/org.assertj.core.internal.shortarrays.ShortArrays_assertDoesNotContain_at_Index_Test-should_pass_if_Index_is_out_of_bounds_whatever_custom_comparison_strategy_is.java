@Test public void should_pass_if_Index_is_out_of_bounds_whatever_custom_comparison_strategy_is(){
  arraysWithCustomComparisonStrategy.assertDoesNotContain(someInfo(),actual,(short)-8,atIndex(6));
}
