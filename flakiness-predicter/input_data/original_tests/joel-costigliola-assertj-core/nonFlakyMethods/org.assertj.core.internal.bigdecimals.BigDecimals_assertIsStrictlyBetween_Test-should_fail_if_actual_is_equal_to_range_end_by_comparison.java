@Test public void should_fail_if_actual_is_equal_to_range_end_by_comparison(){
  AssertionInfo info=someInfo();
  try {
    bigDecimals.assertIsStrictlyBetween(info,ONE,ZERO,new BigDecimal("1.00"));
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(ONE,ZERO,new BigDecimal("1.00"),false,false));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
