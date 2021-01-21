@Test public void should_fail_if_actual_contains_first_elements_of_sequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] sequence={"LeiA","Obi-Wan","Han"};
  try {
    arraysWithCustomComparisonStrategy.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequence,caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
