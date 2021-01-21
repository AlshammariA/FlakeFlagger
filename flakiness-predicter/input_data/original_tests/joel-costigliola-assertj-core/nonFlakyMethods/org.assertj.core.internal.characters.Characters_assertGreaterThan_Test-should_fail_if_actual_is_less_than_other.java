@Test public void should_fail_if_actual_is_less_than_other(){
  AssertionInfo info=someInfo();
  try {
    characters.assertGreaterThan(info,'a','b');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreater('a','b'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
