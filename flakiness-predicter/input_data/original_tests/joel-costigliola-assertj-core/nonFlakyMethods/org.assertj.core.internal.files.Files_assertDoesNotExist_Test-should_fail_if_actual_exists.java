@Test public void should_fail_if_actual_exists(){
  when(actual.exists()).thenReturn(true);
  AssertionInfo info=someInfo();
  try {
    files.assertDoesNotExist(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotExist(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
