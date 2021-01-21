@Test public void should_pass_if_actual_contains_given_values_exactly_in_different_order_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  char[] expected={'A','c','b'};
  try {
    arraysWithCustomComparisonStrategy.assertContainsExactly(someInfo(),actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex('b','c',1,caseInsensitiveComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
