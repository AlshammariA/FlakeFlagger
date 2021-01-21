@Test public void should_fail_if_sequence_is_bigger_than_actual_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  byte[] sequence={6,-8,10,12,20,22};
  try {
    arraysWithCustomComparisonStrategy.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequence,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
