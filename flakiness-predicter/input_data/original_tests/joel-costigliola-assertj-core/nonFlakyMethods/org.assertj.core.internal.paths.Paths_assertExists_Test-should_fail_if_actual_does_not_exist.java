@Test public void should_fail_if_actual_does_not_exist(){
  when(nioFilesWrapper.exists(actual)).thenReturn(false);
  try {
    paths.assertExists(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldExist(actual));
  }
}
