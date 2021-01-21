@Test public void should_succeed_if_actual_exist_and_is_executable(){
  when(nioFilesWrapper.exists(actual)).thenReturn(true);
  when(nioFilesWrapper.isExecutable(actual)).thenReturn(true);
  paths.assertIsExecutable(info,actual);
}
