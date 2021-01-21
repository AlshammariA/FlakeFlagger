@Test public void should_fail_if_actual_is_not_in_range_end(){
  AssertionInfo info=someInfo();
  try {
    doubles.assertIsBetween(info,ONE,ZERO,ZERO);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeBetween(ONE,ZERO,ZERO,true,true));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
