@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    doublesWithAbsValueComparisonStrategy.assertGreaterThan(info,-6d,8d);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(-6d,8d,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
