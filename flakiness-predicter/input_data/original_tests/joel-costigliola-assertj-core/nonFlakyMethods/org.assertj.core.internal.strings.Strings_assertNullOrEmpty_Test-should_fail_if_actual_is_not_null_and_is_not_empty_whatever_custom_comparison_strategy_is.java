@Test public void should_fail_if_actual_is_not_null_and_is_not_empty_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    stringsWithCaseInsensitiveComparisonStrategy.assertNullOrEmpty(info,"Yoda");
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeNullOrEmpty("Yoda"));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
