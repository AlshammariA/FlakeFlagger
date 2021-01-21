@Test public void should_fail_if_sequence_is_bigger_than_actual_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  char[] sequence={'A','b','c','d','e','f'};
  try {
    arraysWithCustomComparisonStrategy.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldStartWith(actual,sequence,caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
