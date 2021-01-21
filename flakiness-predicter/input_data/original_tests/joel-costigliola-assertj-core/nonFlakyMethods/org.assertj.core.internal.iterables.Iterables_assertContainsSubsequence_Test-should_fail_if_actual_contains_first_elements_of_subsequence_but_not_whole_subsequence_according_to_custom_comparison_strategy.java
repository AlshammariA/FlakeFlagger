@Test public void should_fail_if_actual_contains_first_elements_of_subsequence_but_not_whole_subsequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] subsequence={"Luke","Leia","Han"};
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertContainsSubsequence(info,actual,subsequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSubsequence(actual,subsequence,comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
