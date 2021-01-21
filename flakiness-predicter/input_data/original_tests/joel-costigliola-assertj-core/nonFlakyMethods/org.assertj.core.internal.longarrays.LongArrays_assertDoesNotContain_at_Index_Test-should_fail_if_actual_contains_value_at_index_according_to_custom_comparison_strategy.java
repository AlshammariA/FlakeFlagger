@Test public void should_fail_if_actual_contains_value_at_index_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Index index=atIndex(0);
  try {
    arraysWithCustomComparisonStrategy.assertDoesNotContain(info,actual,6L,index);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainAtIndex(actual,6L,index,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
