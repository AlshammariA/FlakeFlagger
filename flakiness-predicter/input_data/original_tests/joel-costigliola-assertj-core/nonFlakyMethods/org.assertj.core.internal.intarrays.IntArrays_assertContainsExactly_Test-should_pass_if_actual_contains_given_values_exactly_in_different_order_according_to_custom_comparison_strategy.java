@Test public void should_pass_if_actual_contains_given_values_exactly_in_different_order_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  int[] expected={-6,10,8};
  try {
    arraysWithCustomComparisonStrategy.assertContainsExactly(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex(8,10,1,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
