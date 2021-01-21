@Test public void should_fail_if_sequence_is_smaller_than_end_of_actual(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Luke","Leia"};
  try {
    iterables.assertEndsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
