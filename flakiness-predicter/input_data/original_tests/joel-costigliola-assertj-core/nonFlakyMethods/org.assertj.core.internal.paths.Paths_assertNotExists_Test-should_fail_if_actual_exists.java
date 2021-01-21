@Test public void should_fail_if_actual_exists(){
  when(nioFilesWrapper.notExists(actual)).thenReturn(false);
  try {
    paths.assertDoesNotExist(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldNotExist(actual));
  }
}
