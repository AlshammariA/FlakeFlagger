@Test public void should_fail_if_actual_does_not_start_with_sequence(){
  AssertionInfo info=someInfo();
  int[] sequence={8,10};
  try {
    arrays.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
