@Test public void should_fail_if_actual_does_not_contain_whole_sequence(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Han","C-3PO"};
  try {
    iterables.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
