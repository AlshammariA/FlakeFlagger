@Test public void should_fail_if_actual_contains_given_values_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  Object[] expected={"LuKe","YODA","Han"};
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertDoesNotContain(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContain(actual,expected,newLinkedHashSet("LuKe","YODA"),comparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
