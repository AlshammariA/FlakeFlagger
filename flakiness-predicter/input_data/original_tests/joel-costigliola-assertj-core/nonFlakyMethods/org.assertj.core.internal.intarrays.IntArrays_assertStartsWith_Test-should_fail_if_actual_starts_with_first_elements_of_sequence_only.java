@Test public void should_fail_if_actual_starts_with_first_elements_of_sequence_only(){
  AssertionInfo info=someInfo();
  int[] sequence={6,20};
  try {
    arrays.assertStartsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
