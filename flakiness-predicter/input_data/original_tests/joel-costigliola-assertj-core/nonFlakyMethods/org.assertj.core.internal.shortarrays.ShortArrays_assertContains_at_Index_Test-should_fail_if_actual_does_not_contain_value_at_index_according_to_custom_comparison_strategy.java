@Test public void should_fail_if_actual_does_not_contain_value_at_index_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  short value=6;
  Index index=atIndex(1);
  try {
    arraysWithCustomComparisonStrategy.assertContains(info,actual,value,index);
  }
 catch (  AssertionError e) {
    short found=8;
    verify(failures).failure(info,shouldContainAtIndex(actual,value,index,found,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
