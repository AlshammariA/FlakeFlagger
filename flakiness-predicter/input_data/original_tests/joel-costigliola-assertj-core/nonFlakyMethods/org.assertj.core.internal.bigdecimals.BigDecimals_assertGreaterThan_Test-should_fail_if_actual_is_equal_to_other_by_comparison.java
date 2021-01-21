@Test public void should_fail_if_actual_is_equal_to_other_by_comparison(){
  AssertionInfo info=someInfo();
  try {
    bigDecimals.assertGreaterThan(info,TEN,new BigDecimal("10.00"));
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater(TEN,new BigDecimal("10.00")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
