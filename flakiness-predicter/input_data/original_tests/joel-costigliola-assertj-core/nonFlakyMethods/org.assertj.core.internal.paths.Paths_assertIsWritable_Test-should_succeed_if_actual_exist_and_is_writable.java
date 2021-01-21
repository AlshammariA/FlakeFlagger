@Test public void should_succeed_if_actual_exist_and_is_writable(){
  when(nioFilesWrapper.exists(actual)).thenReturn(true);
  when(nioFilesWrapper.isWritable(actual)).thenReturn(true);
  paths.assertIsWritable(info,actual);
}
