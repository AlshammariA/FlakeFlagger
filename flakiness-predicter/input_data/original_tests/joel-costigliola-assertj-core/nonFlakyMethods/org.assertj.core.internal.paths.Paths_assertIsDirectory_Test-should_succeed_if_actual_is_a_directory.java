@Test public void should_succeed_if_actual_is_a_directory(){
  when(nioFilesWrapper.exists(actual)).thenReturn(true);
  when(nioFilesWrapper.isDirectory(actual)).thenReturn(true);
  paths.assertIsDirectory(info,actual);
}
