@Test public void should_fail_if_actual_does_not_end_with_sequence(){
  AssertionInfo info=someInfo();
  boolean[] sequence={true,false};
  try {
    arrays.assertEndsWith(someInfo(),actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
