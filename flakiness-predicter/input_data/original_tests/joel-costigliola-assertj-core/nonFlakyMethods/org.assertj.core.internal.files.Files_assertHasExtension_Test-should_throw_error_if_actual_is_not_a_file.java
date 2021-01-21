@Test public void should_throw_error_if_actual_is_not_a_file() throws Exception {
  AssertionInfo info=someInfo();
  when(actual.isFile()).thenReturn(false);
  try {
    files.assertHasExtension(info,actual,expectedExtension);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeFile(actual));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
