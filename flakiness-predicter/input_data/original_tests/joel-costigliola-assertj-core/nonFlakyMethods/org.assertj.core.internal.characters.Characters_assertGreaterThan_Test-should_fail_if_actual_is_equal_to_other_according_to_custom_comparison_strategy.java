@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo someInfo=someInfo();
  try {
    charactersWithCaseInsensitiveComparisonStrategy.assertGreaterThan(someInfo,'B','b');
  }
 catch (  AssertionError e) {
    verify(failures).failure(someInfo,shouldBeGreater('B','b',caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
