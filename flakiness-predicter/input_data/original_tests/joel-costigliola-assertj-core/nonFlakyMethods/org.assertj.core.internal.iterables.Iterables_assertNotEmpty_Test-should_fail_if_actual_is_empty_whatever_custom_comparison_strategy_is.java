@Test public void should_fail_if_actual_is_empty_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertNotEmpty(info,emptyList());
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEmpty());
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
