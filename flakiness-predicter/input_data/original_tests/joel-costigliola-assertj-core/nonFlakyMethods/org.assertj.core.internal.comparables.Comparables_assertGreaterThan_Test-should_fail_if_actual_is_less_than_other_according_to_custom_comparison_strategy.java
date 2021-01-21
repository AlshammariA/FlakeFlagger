@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    comparablesWithCustomComparisonStrategy.assertGreaterThan(info,-6,8);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(-6,8,customComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
