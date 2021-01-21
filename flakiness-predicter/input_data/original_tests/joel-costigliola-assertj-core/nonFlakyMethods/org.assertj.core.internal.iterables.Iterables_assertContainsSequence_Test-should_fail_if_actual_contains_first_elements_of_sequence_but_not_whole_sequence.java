@Test public void should_fail_if_actual_contains_first_elements_of_sequence_but_not_whole_sequence(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Luke","Leia","Han"};
  try {
    iterables.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
