@Test public void should_fail_if_actual_does_not_start_with_sequence(){
  AssertionInfo info=someInfo();
  boolean[] sequence={false,true};
  try {
    arrays.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
