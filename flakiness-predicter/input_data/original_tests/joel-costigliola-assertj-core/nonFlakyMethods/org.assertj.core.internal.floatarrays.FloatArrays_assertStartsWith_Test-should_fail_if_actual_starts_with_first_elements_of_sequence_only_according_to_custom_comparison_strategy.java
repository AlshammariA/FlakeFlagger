@Test public void should_fail_if_actual_starts_with_first_elements_of_sequence_only_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  float[] sequence={6f,20f};
  try {
    arraysWithCustomComparisonStrategy.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(someInfo(),shouldStartWith(actual,sequence,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
