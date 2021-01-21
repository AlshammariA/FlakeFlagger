@Test public void should_fail_if_actual_contains_given_values_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  char[] expected={'A','b','d'};
  try {
    arraysWithCustomComparisonStrategy.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet('A','b'),caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
