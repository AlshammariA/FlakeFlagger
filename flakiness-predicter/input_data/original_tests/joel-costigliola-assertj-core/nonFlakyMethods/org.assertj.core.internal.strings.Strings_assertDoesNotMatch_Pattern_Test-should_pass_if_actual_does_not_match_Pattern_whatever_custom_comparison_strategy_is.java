@Test public void should_pass_if_actual_does_not_match_Pattern_whatever_custom_comparison_strategy_is(){
  stringsWithCaseInsensitiveComparisonStrategy.assertDoesNotMatch(someInfo(),actual,Pattern.compile("Luke"));
}
