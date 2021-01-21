@Test public void should_fail_if_actual_is_equal_to_range_start_by_comparison(){
  AssertionInfo info=someInfo();
  try {
    bigDecimals.assertIsStrictlyBetween(info,ONE,new BigDecimal("1.00"),TEN);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(ONE,new BigDecimal("1.00"),TEN,false,false));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
