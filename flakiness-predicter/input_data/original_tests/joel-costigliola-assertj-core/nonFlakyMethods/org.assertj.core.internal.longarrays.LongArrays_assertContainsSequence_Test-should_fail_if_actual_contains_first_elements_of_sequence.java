@Test public void should_fail_if_actual_contains_first_elements_of_sequence(){
  AssertionInfo info=someInfo();
  long[] sequence={6L,20L,22L};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
