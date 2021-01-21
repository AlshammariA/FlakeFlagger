@Test public void should_fail_if_actual_contains_first_elements_of_sequence(){
  AssertionInfo info=someInfo();
  int[] sequence={6,20,22};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequence));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
