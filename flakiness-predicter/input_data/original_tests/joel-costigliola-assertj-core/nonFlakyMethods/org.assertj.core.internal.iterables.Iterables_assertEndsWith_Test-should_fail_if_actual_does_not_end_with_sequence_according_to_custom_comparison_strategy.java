@Test public void should_fail_if_actual_does_not_end_with_sequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Han","C-3PO"};
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertEndsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldEndWith(actual,sequence,comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
