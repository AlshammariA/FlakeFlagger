@Test public void should_fail_if_actual_contains_first_elements_of_sequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  char[] sequence={6,20,22};
  try {
    arraysWithCustomComparisonStrategy.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequence,caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
