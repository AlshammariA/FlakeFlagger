@Test public void should_pass_if_actual_exists(){
  when(nioFilesWrapper.exists(actual,LinkOption.NOFOLLOW_LINKS)).thenReturn(true);
  paths.assertExistsNoFollowLinks(info,actual);
}
