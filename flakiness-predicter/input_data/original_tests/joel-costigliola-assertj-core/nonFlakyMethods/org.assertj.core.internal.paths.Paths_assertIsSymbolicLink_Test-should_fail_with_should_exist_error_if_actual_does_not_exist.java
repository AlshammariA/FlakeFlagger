@Test public void should_fail_with_should_exist_error_if_actual_does_not_exist(){
  when(nioFilesWrapper.exists(actual,LinkOption.NOFOLLOW_LINKS)).thenReturn(false);
  try {
    paths.assertIsSymbolicLink(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldExistNoFollowLinks(actual));
  }
}
