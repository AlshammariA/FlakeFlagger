@Test public void should_succeed_since_actual_is_positive_according_to_custom_comparison_strategy(){
  shortsWithAbsValueComparisonStrategy.assertIsPositive(someInfo(),(short)-1);
}
