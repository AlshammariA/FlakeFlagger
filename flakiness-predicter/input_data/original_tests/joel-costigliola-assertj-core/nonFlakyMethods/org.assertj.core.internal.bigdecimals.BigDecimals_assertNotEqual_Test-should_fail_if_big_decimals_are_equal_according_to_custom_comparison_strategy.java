@Test public void should_fail_if_big_decimals_are_equal_according_to_custom_comparison_strategy(){
  AssertionInfo info=someInfo();
  try {
    bigDecimalsWithComparatorComparisonStrategy.assertNotEqual(info,ONE_WITH_3_DECIMALS,ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(ONE_WITH_3_DECIMALS,ONE,comparatorComparisonStrategy));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
