@Test public void should_fail_if_actual_contains_first_elements_of_subsequence(){
  AssertionInfo info=someInfo();
  Object[] subsequence={"Leia","Obi-Wan","Han"};
  try {
    arrays.assertContainsSubsequence(info,actual,subsequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSubsequenceNotFound(info,subsequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
