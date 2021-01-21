@Test public void should_fail_if_actual_exists_but_is_not_executable(){
  try {
    when(nioFilesWrapper.exists(actual)).thenReturn(true);
    when(nioFilesWrapper.isExecutable(actual)).thenReturn(false);
    paths.assertIsExecutable(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeExecutable(actual));
  }
}
