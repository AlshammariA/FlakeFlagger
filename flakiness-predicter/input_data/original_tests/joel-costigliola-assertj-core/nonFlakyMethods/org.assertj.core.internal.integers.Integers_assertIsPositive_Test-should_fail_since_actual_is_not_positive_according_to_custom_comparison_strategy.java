@Test public void should_fail_since_actual_is_not_positive_according_to_custom_comparison_strategy(){
  thrown.expectAssertionError("\nExpecting:\n <0>\nto be greater than:\n <0> when comparing values using 'AbsValueComparator'");
  integersWithAbsValueComparisonStrategy.assertIsPositive(someInfo(),0);
}
