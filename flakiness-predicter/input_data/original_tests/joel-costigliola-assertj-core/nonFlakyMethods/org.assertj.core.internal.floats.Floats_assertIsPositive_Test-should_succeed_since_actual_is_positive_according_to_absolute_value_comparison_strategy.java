@Test public void should_succeed_since_actual_is_positive_according_to_absolute_value_comparison_strategy(){
  floatsWithAbsValueComparisonStrategy.assertIsPositive(someInfo(),(float)6);
}
