@Test public void should_throw_error_if_sequence_is_null_whatever_custom_comparison_strategy_is(){
  thrown.expectNullPointerException(valuesToLookForIsNull());
  arraysWithCustomComparisonStrategy.assertStartsWith(someInfo(),actual,null);
}
