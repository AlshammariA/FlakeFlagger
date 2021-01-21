@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    longsWithAbsValueComparisonStrategy.assertGreaterThanOrEqualTo(info,6L,-8L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreaterOrEqual(6L,-8L,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
