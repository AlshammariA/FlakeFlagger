@Test public void should_fail_if_big_decimals_are_not_equal(){
  AssertionInfo info=someInfo();
  try {
    bigDecimals.assertEqual(info,ONE_WITH_3_DECIMALS,ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeEqual(ONE_WITH_3_DECIMALS,ONE,info.representation()));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
