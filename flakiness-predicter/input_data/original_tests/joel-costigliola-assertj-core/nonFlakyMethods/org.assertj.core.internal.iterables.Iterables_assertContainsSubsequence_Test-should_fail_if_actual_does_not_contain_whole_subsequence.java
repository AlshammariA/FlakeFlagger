@Test public void should_fail_if_actual_does_not_contain_whole_subsequence(){
  AssertionInfo info=someInfo();
  Object[] subsequence={"Han","C-3PO"};
  try {
    iterables.assertContainsSubsequence(info,actual,subsequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSubsequenceNotFound(info,subsequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
