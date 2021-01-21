@Test public void should_fail_if_actual_does_not_contain_whole_sequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Han","C-3PO"};
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequence,comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
