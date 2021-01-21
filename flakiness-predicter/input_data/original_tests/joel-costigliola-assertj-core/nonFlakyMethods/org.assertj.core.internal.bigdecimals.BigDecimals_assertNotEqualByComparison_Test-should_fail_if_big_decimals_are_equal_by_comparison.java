@Test public void should_fail_if_big_decimals_are_equal_by_comparison(){
  AssertionInfo info=someInfo();
  try {
    bigDecimals.assertNotEqualByComparison(info,ONE_WITH_3_DECIMALS,ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotBeEqual(ONE_WITH_3_DECIMALS,ONE));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
