@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    longsWithAbsValueComparisonStrategy.assertGreaterThan(info,-6L,6L);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(-6L,6L,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
