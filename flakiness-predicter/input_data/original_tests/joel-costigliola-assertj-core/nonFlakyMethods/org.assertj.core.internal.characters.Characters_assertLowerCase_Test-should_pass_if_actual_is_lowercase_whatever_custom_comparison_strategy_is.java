@Test public void should_pass_if_actual_is_lowercase_whatever_custom_comparison_strategy_is(){
  charactersWithCaseInsensitiveComparisonStrategy.assertLowerCase(someInfo(),'a');
}
