@Test public void should_pass_if_actual_contains_subsequence_according_to_custom_comparison_strategy(){
  iterablesWithCaseInsensitiveComparisonStrategy.assertContainsSubsequence(someInfo(),actual,array("yODa","leia"));
}
