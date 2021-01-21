@Test public void should_fail_if_actual_does_not_contain_whole_subsequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] subsequence={"Han","C-3PO"};
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertContainsSubsequence(info,actual,subsequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSubsequence(actual,subsequence,comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
