@Test public void should_fail_if_actual_path_does_not_exist(){
  AssertionInfo info=someInfo();
  when(nioFilesWrapper.exists(mockPath)).thenReturn(false);
  try {
    paths.assertHasBinaryContent(info,mockPath,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldExist(mockPath));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
