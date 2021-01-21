@Test public void should_fail_if_target_exists_but_is_not_a_regular_file(){
  when(nioFilesWrapper.exists(actual)).thenReturn(true);
  when(nioFilesWrapper.isRegularFile(actual)).thenReturn(false);
  try {
    paths.assertIsRegularFile(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeRegularFile(actual));
  }
}
