@Test public void should_fail_if_actual_does_not_contain_whole_subsequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Han","C-3PO"};
  try {
    arraysWithCustomComparisonStrategy.assertContainsSubsequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSubsequence(actual,sequence,caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
