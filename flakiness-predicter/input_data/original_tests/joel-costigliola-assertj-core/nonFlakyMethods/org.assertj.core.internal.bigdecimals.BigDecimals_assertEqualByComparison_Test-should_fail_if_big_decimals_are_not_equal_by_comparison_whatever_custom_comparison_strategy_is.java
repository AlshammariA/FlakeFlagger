@Test public void should_fail_if_big_decimals_are_not_equal_by_comparison_whatever_custom_comparison_strategy_is(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithAbsValueComparisonStrategy.assertEqualByComparison(info,TEN,ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(TEN,ONE,absValueComparisonStrategy,new StandardRepresentation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
