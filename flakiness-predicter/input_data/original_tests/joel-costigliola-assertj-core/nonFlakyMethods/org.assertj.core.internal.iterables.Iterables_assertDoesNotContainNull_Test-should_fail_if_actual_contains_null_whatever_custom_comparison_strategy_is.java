@Test public void should_fail_if_actual_contains_null_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  actual=newArrayList("Luke","Yoda",null);
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertDoesNotContainNull(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotContainNull(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
