@Test public void should_fail_if_actual_is_equal_to_other(){
  AssertionInfo info=someInfo();
  try {
    bigDecimals.assertLessThan(info,TEN,TEN);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeLess(TEN,TEN));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
