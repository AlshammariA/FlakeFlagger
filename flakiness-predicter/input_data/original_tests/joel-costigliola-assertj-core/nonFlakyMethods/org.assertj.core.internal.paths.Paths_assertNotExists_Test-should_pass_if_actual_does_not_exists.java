@Test public void should_pass_if_actual_does_not_exists(){
  when(nioFilesWrapper.notExists(actual,LinkOption.NOFOLLOW_LINKS)).thenReturn(true);
  paths.assertDoesNotExist(info,actual);
}
