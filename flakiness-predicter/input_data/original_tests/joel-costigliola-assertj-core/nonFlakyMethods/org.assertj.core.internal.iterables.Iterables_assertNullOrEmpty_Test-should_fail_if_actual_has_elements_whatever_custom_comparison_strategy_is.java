@Test public void should_fail_if_actual_has_elements_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  Collection<String> actual=newArrayList("Yoda");
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertNullOrEmpty(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeNullOrEmpty(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
