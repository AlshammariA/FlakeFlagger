@Test public void should_pass_if_actual_contains_only_null_values_whatever_custom_comparison_strategy_is(){
  actual=newArrayList(null,null);
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsNull(someInfo(),actual);
}
