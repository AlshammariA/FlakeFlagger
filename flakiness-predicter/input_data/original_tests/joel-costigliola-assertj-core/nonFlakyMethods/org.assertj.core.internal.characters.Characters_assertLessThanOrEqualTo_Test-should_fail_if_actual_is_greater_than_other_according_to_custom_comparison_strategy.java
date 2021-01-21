@Test public void should_fail_if_actual_is_greater_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertLessThanOrEqualTo(info,'B','a');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLessOrEqual('B','a',caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
