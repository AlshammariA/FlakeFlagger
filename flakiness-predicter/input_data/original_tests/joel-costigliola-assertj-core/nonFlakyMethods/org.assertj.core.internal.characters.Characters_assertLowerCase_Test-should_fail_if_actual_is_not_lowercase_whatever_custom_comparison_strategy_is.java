@Test public void should_fail_if_actual_is_not_lowercase_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertLowerCase(info,'A');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLowerCase('A'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
