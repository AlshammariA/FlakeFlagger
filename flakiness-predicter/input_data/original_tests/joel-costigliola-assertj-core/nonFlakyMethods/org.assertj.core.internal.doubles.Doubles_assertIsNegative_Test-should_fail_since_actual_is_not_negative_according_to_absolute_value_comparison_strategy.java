@Test public void should_fail_since_actual_is_not_negative_according_to_absolute_value_comparison_strategy(){
  thrown.expectAssertionError("\nExpecting:\n <-6.0>\nto be less than:\n <0.0> when comparing values using 'AbsValueComparator'");
  doublesWithAbsValueComparisonStrategy.assertIsNegative(someInfo(),-6.0d);
}
