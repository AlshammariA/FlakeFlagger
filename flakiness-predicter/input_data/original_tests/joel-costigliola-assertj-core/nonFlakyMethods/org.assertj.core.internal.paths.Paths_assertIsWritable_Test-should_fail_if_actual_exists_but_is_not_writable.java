@Test public void should_fail_if_actual_exists_but_is_not_writable(){
  try {
    when(nioFilesWrapper.exists(actual)).thenReturn(true);
    when(nioFilesWrapper.isWritable(actual)).thenReturn(false);
    paths.assertIsWritable(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeWritable(actual));
  }
}
