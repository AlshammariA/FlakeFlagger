@Test public void should_succeed_since_actual_is_positive_according_to_absolute_value_comparison_strategy2(){
  floatsWithAbsValueComparisonStrategy.assertIsPositive(someInfo(),-6.0f);
}
