@Test public void should_pass_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  floatsWithAbsValueComparisonStrategy.assertGreaterThanOrEqualTo(someInfo(),-6f,6f);
  floatsWithAbsValueComparisonStrategy.assertGreaterThanOrEqualTo(someInfo(),6f,6f);
}
