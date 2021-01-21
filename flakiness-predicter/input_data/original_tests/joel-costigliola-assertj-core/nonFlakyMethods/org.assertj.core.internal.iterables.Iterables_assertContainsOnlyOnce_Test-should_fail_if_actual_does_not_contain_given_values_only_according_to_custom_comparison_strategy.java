@Test public void should_fail_if_actual_does_not_contain_given_values_only_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] expected={"Luke","Yoda","Han"};
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertContainsOnlyOnce(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainsOnlyOnce(actual,expected,newLinkedHashSet("Han"),newLinkedHashSet(),comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
