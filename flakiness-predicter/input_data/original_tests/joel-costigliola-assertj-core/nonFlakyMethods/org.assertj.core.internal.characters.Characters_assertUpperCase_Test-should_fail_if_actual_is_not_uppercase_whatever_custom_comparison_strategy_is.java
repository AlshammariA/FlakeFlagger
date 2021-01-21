@Test public void should_fail_if_actual_is_not_uppercase_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertUpperCase(info,'a');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeUpperCase('a'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
