@Test public void should_fail_if_actual_contains_duplicates_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=arrayOf('A','b','A','b');
  try {
    arraysWithCustomComparisonStrategy.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet('A','b'),caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
