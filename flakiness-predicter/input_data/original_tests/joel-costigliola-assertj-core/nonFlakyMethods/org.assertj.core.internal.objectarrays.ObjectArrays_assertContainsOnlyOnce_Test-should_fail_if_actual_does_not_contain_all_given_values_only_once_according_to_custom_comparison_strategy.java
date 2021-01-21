@Test public void should_fail_if_actual_does_not_contain_all_given_values_only_once_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  String[] expected={"Luke","yoda","han"};
  try {
    arraysWithCustomComparisonStrategy.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("han"),newLinkedHashSet(),caseInsensitiveStringComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
