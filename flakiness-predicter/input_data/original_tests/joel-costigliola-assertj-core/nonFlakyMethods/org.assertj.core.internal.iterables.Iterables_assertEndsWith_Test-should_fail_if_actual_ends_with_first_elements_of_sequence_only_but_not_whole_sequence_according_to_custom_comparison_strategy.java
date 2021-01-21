@Test public void should_fail_if_actual_ends_with_first_elements_of_sequence_only_but_not_whole_sequence_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Leia","Obi-Wan","Han"};
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertEndsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldEndWith(actual,sequence,comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
