@Test public void should_fail_if_actual_contains_first_elements_of_sequence(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Leia","Obi-Wan","Han"};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
