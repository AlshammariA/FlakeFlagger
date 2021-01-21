@Test public void should_fail_if_sequence_is_bigger_than_actual(){
  AssertionInfo info=someInfo();
  boolean[] sequence={true,true,true,false,false,false};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
