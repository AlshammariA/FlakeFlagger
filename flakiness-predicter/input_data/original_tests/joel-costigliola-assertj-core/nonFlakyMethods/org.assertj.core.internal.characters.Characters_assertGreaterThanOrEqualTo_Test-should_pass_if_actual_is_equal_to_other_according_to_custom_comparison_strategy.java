@Test public void should_pass_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  charactersWithCaseInsensitiveComparisonStrategy.assertGreaterThanOrEqualTo(someInfo(),'B','b');
}
