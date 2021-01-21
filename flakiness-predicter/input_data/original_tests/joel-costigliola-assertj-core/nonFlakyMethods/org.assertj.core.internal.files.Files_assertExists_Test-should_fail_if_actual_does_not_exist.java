@Test public void should_fail_if_actual_does_not_exist(){
  when(actual.exists()).thenReturn(false);
  AssertionInfo info=someInfo();
  try {
    files.assertExists(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldExist(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
