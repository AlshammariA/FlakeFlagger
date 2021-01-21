@Test public void should_fail_if_actual_does_not_contain_null_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  actual=newArrayList("Luke","Yoda");
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertContainsNull(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainNull(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
