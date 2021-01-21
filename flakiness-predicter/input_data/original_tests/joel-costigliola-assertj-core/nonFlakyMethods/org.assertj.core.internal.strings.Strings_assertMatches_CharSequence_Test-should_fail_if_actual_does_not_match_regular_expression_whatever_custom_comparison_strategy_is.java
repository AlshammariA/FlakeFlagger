@Test public void should_fail_if_actual_does_not_match_regular_expression_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    stringsWithCaseInsensitiveComparisonStrategy.assertMatches(info,actual,"Luke");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldMatch(actual,"Luke"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
