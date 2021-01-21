@Test public void should_fail_if_actual_is_null_and_expected_is_not(){
  AssertionInfo info=someInfo();
  try {
    strings.assertEqualsIgnoringWhitespace(info,null,"Luke");
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenStringsAreNotEqualIgnoringWhitespace(info,null,"Luke");
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
