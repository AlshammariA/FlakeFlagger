@Test public void should_fail_if_actual_is_not_a_readable_file(){
  AssertionInfo info=someInfo();
  when(nioFilesWrapper.exists(mockPath)).thenReturn(true);
  when(nioFilesWrapper.isReadable(mockPath)).thenReturn(false);
  try {
    paths.assertHasContent(info,mockPath,expected,charset);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeReadable(mockPath));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
