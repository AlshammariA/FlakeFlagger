@Test public void should_succeed_since_actual_positive_is_not_negative_according_to_custom_comparison_strategy(){
  doublesWithAbsValueComparisonStrategy.assertIsNotNegative(someInfo(),1d);
}
