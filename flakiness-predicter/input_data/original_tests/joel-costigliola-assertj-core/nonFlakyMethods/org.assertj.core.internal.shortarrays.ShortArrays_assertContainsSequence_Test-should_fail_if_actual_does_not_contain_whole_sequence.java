@Test public void should_fail_if_actual_does_not_contain_whole_sequence(){
  AssertionInfo info=someInfo();
  short[] sequence={6,20};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
