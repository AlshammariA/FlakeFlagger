@Test public void should_fail_with_should_exist_error_if_actual_does_not_exist(){
  when(nioFilesWrapper.exists(actual)).thenReturn(false);
  try {
    paths.assertIsRegularFile(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldExist(actual));
  }
}
