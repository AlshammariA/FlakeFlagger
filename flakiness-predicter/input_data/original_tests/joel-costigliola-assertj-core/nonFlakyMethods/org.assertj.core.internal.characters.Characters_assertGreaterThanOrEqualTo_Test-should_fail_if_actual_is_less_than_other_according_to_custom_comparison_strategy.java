@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertGreaterThanOrEqualTo(info,'a','B');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreaterOrEqual('a','B',caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
