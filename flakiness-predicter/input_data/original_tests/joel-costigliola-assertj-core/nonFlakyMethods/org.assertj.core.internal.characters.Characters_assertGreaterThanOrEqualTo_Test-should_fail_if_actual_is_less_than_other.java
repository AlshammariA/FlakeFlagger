@Test public void should_fail_if_actual_is_less_than_other(){
  AssertionInfo info=someInfo();
  try {
    characters.assertGreaterThanOrEqualTo(info,'a','b');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeGreaterOrEqual('a','b'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
