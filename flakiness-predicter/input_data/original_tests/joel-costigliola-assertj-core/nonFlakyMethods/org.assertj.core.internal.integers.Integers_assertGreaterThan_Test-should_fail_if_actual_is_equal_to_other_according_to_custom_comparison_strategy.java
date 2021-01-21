@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    integersWithAbsValueComparisonStrategy.assertGreaterThan(info,6,-6);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(6,-6,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
