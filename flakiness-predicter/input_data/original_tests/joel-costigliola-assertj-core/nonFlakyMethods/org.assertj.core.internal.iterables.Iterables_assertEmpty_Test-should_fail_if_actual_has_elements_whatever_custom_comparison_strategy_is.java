@Test public void should_fail_if_actual_has_elements_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  Collection<String> actual=newArrayList("Yoda");
  try {
    iterablesWithCaseInsensitiveComparisonStrategy.assertEmpty(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEmpty(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
