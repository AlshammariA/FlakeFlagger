@Test public void should_fail_if_actual_ends_with_first_elements_of_sequence_only_but_not_whole_sequence(){
  AssertionInfo info=someInfo();
  Object[] sequence={"Leia","Obi-Wan","Han"};
  try {
    iterables.assertEndsWith(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verifyFailureThrownWhenSequenceNotFound(info,sequence);
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
