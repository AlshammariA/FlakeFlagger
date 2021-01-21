@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    floatsWithAbsValueComparisonStrategy.assertGreaterThan(info,-6f,8f);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(-6f,8f,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
