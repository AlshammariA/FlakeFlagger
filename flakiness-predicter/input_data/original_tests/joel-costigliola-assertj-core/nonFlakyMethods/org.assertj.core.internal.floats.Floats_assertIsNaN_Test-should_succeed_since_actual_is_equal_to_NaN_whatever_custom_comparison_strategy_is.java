@Test public void should_succeed_since_actual_is_equal_to_NaN_whatever_custom_comparison_strategy_is(){
  floatsWithAbsValueComparisonStrategy.assertIsNaN(someInfo(),Float.NaN);
}
