@Test public void should_fail_if_actual_does_not_exist(){
  when(nioFilesWrapper.exists(actual,LinkOption.NOFOLLOW_LINKS)).thenReturn(false);
  try {
    paths.assertExistsNoFollowLinks(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldExistNoFollowLinks(actual));
  }
}
