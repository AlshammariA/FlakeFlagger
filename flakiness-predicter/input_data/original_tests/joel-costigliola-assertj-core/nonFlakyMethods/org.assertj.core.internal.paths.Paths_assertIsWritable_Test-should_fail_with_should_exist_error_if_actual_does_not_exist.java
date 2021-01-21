@Test public void should_fail_with_should_exist_error_if_actual_does_not_exist(){
  try {
    when(nioFilesWrapper.exists(actual)).thenReturn(false);
    paths.assertIsWritable(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldExist(actual));
  }
}
