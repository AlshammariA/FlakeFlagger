@Test public void should_fail_if_actual_contains_duplicates_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=arrayOf(6L,-8L,6L,-8L);
  try {
    arraysWithCustomComparisonStrategy.assertDoesNotHaveDuplicates(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotHaveDuplicates(actual,newLinkedHashSet(6L,-8L),absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
