@Test public void should_succeed_if_actual_is_an_existing_regular_file(){
  when(nioFilesWrapper.exists(actual)).thenReturn(true);
  when(nioFilesWrapper.isRegularFile(actual)).thenReturn(true);
  paths.assertIsRegularFile(info,actual);
}
