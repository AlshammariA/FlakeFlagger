@Test public void should_fail_if_actual_contains_given_values_only_more_than_once_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=arrayOf('a','B','b','A','c','d');
  char[] expected={'a','B','e'};
  try {
    arraysWithCustomComparisonStrategy.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet('e'),newLinkedHashSet('a','B'),caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
