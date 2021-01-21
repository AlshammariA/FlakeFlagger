@Test public void should_fail_if_actual_contains_first_elements_of_sequence(){
  AssertionInfo info=someInfo();
  float[] sequence={6f,20f,22f};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequence));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
