@Test public void should_fail_if_sequence_is_bigger_than_actual_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] subsequence={"LUKE","LeiA","Obi-Wan","Han","C-3PO","R2-D2","Anakin"};
  try {
    arraysWithCustomComparisonStrategy.assertContainsSubsequence(info,actual,subsequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSubsequence(actual,subsequence,caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
