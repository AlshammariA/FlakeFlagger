@Test public void should_fail_if_subsequence_is_bigger_than_actual(){
  AssertionInfo info=someInfo();
  Object[] subsequence={"Luke","Leia","Obi-Wan","Han","C-3PO","R2-D2","Anakin"};
  try {
    arrays.assertContainsSubsequence(info,actual,subsequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSubsequenceNotFound(info,subsequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
