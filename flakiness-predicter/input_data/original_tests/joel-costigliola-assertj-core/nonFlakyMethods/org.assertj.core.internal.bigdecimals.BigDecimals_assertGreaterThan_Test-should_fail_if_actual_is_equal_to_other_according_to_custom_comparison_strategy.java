@Test public void should_fail_if_actual_is_equal_to_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithAbsValueComparisonStrategy.assertGreaterThan(info,TEN.negate(),TEN);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(TEN.negate(),TEN,absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
