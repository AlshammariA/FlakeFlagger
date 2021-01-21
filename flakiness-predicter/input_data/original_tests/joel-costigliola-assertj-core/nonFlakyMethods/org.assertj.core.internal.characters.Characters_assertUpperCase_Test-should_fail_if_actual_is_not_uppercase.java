@Test public void should_fail_if_actual_is_not_uppercase(){
  AssertionInfo info=someInfo();
  try {
    characters.assertUpperCase(info,'a');
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeUpperCase('a'));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
