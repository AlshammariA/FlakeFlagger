@Test public void should_succeed_since_actual_is_positive_according_to_absolute_value_comparison_strategy(){
  doublesWithAbsValueComparisonStrategy.assertIsPositive(someInfo(),6.0d);
}
