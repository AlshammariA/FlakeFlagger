@Test public void should_fail_if_actual_does_not_contain_given_values_exactly_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] expected={"Luke","Yoda","Han"};
  try {
    arraysWithCustomComparisonStrategy.assertContainsExactly(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainExactly(actual,expected,newLinkedHashSet("Han"),newLinkedHashSet("Leia"),caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
