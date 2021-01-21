@Test public void should_fail_if_actual_contains_first_elements_of_subsequence_but_not_whole_subsequence(){
  AssertionInfo info=someInfo();
  Object[] subsequence={"Luke","Leia","Han"};
  try {
    iterables.assertContainsSubsequence(info,actual,subsequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSubsequenceNotFound(info,subsequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
