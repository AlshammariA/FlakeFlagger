@Test public void should_pass_if_actual_is_uppercase_whatever_custom_comparison_strategy_is(){
  charactersWithCaseInsensitiveComparisonStrategy.assertUpperCase(someInfo(),'A');
}
