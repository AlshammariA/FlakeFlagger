@Test public void should_pass_if_actual_contains_null_more_than_once_whatever_custom_comparison_strategy_is(){
  actual.add(null);
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsNull(someInfo(),actual);
}
