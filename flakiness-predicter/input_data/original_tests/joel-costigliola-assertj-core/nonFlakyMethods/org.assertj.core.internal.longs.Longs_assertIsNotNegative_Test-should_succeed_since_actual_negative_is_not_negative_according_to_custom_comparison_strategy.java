@Test public void should_succeed_since_actual_negative_is_not_negative_according_to_custom_comparison_strategy(){
  longsWithAbsValueComparisonStrategy.assertIsNotNegative(someInfo(),-1L);
}
