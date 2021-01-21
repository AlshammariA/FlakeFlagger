@Test public void should_fail_if_actual_does_not_start_with_sequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  long[] sequence={-8L,10L};
  try {
    arraysWithCustomComparisonStrategy.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldStartWith(actual,sequence,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
