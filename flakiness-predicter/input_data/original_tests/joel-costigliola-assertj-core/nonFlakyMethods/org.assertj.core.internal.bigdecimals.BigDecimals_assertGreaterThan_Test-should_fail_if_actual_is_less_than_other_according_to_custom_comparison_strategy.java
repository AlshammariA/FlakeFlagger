@Test public void should_fail_if_actual_is_less_than_other_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithAbsValueComparisonStrategy.assertGreaterThan(info,ONE,TEN.negate());
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(ONE,TEN.negate(),absValueComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
