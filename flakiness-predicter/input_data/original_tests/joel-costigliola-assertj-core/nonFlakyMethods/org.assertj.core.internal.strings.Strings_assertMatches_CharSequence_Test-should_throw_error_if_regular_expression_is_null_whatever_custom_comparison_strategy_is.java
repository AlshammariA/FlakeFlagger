@Test public void should_throw_error_if_regular_expression_is_null_whatever_custom_comparison_strategy_is(){
  thrown.expectNullPointerException(regexPatternIsNull());
  String regex=null;
  stringsWithCaseInsensitiveComparisonStrategy.assertMatches(someInfo(),actual,regex);
}
