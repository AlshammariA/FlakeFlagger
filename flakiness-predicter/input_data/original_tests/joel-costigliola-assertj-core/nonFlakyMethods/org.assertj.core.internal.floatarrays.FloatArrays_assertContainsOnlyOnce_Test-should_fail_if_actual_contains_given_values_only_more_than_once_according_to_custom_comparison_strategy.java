@Test public void should_fail_if_actual_contains_given_values_only_more_than_once_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  actual=arrayOf(6,-8,10,-6,-8,10,-8);
  float[] expected={6,-8,20};
  try {
    arraysWithCustomComparisonStrategy.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet((float)20),newLinkedHashSet((float)6,(float)-8),absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
