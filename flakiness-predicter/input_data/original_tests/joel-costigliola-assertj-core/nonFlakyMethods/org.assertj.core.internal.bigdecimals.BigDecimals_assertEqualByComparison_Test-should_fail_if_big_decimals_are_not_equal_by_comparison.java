@Test public void should_fail_if_big_decimals_are_not_equal_by_comparison(){
  AssertionInfo info=someInfo();
  try {
    bigDecimals.assertEqualByComparison(info,TEN,ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(TEN,ONE,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
