@Test public void should_fail_if_target_exists_but_is_not_a_directory(){
  when(nioFilesWrapper.exists(actual)).thenReturn(true);
  when(nioFilesWrapper.isDirectory(actual)).thenReturn(false);
  try {
    paths.assertIsDirectory(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeDirectory(actual));
  }
}
