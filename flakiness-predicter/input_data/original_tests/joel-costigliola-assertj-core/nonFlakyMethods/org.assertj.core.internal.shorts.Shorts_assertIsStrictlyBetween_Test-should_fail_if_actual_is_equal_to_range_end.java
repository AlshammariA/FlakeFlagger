@Test public void should_fail_if_actual_is_equal_to_range_end(){
  AssertionInfo info=someInfo();
  try {
    shorts.assertIsStrictlyBetween(info,ONE,ZERO,ONE);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(ONE,ZERO,ONE,false,false));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
