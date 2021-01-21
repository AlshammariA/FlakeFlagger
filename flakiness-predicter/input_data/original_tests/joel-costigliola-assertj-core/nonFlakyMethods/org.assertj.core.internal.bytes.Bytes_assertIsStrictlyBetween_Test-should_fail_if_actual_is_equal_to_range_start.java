@Test public void should_fail_if_actual_is_equal_to_range_start(){
  AssertionInfo info=someInfo();
  try {
    bytes.assertIsStrictlyBetween(info,ONE,ONE,TEN);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(ONE,ONE,TEN,false,false));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
