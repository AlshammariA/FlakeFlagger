@Test public void should_fail_if_actual_is_not_in_range_start(){
  AssertionInfo info=someInfo();
  try {
    floats.assertIsStrictlyBetween(info,ONE,TWO,TEN);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(ONE,TWO,TEN,false,false));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
