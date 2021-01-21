@Test public void should_fail_if_actual_contains_all_given_values_in_different_order_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] expected={"Luke","Leia","Yoda"};
  try {
    arraysWithCustomComparisonStrategy.assertContainsExactly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,elementsDifferAtIndex("Yoda","Leia",1,caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
