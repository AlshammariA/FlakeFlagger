@Test public void should_fail_if_actual_does_not_contain_value_at_index_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  long value=6;
  Index index=atIndex(1);
  try {
    arraysWithCustomComparisonStrategy.assertContains(info,actual,value,index);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainAtIndex(actual,value,index,8L,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
