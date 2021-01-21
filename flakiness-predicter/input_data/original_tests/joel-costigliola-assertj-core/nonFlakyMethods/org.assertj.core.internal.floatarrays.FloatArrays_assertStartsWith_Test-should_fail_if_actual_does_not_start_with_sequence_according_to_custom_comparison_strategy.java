@Test public void should_fail_if_actual_does_not_start_with_sequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  float[] sequence={-8f,10f};
  try {
    arraysWithCustomComparisonStrategy.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(someInfo(),shouldStartWith(actual,sequence,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
