@Test public void should_fail_if_sequence_is_bigger_than_actual(){
  AssertionInfo info=someInfo();
  long[] sequence={6L,8L,10L,12L,20L,22L};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
