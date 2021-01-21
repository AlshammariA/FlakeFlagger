@Test public void should_fail_if_actual_exists_but_is_not_readable(){
  try {
    when(nioFilesWrapper.exists(actual)).thenReturn(true);
    when(nioFilesWrapper.isReadable(actual)).thenReturn(false);
    paths.assertIsReadable(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeReadable(actual));
  }
}
