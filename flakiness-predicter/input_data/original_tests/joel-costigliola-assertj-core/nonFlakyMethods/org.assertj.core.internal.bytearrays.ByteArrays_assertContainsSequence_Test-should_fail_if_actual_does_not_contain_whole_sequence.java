@Test public void should_fail_if_actual_does_not_contain_whole_sequence(){
  AssertionInfo info=someInfo();
  byte[] sequence={6,20};
  try {
    arrays.assertContainsSequence(info,actual,sequence);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldContainSequence(actual,sequence));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
