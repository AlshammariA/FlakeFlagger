@Test public void should_succeed_since_actual_is_zero_whatever_custom_comparison_strategy_is(){
  doublesWithAbsValueComparisonStrategy.assertIsZero(someInfo(),0.0d);
}
