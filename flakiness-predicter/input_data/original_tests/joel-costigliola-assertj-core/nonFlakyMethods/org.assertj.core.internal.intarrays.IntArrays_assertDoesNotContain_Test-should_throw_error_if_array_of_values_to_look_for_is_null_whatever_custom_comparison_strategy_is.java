@Test public void should_throw_error_if_array_of_values_to_look_for_is_null_whatever_custom_comparison_strategy_is(){
  thrown.expectNullPointerException(valuesToLookForIsNull());
  arraysWithCustomComparisonStrategy.assertDoesNotContain(someInfo(),actual,null);
}
