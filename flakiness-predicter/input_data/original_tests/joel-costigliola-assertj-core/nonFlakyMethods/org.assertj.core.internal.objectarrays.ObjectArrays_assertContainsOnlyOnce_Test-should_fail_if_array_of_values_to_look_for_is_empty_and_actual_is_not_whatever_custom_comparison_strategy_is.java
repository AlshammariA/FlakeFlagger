@Test public void should_fail_if_array_of_values_to_look_for_is_empty_and_actual_is_not_whatever_custom_comparison_strategy_is(){
  thrown.expect(AssertionError.class);
  arraysWithCustomComparisonStrategy.assertContainsOnlyOnce(someInfo(),actual,emptyArray());
}
