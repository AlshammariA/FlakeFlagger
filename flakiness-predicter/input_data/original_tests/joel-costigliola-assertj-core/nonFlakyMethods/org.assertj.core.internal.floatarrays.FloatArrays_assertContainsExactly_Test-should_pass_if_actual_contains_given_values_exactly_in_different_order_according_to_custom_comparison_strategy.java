@Test public void should_pass_if_actual_contains_given_values_exactly_in_different_order_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  float[] expected={-6f,10f,8f};
  try {
    arraysWithCustomComparisonStrategy.assertContainsExactly(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex(8f,10f,1,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
