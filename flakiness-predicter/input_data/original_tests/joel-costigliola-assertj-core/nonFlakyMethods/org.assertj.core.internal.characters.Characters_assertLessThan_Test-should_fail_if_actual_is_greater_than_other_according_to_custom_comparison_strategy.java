@Test public void should_fail_if_actual_is_greater_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertLessThan(info,'B','a');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess('B','a',caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
