@Test public void should_fail_if_actual_is_not_directory(){
  when(actual.isDirectory()).thenReturn(false);
  AssertionInfo info=someInfo();
  try {
    files.assertIsDirectory(info,actual);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeDirectory(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
