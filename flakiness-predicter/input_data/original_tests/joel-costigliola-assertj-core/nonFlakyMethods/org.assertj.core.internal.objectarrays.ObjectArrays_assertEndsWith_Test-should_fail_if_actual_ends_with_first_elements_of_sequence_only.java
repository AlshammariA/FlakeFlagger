@Test public void should_fail_if_actual_ends_with_first_elements_of_sequence_only(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Leia","Obi-Wan","Han"};
  try {
    arrays.assertEndsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
