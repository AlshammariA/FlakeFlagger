@Test public void should_pass_if_actual_exists(){
  when(nioFilesWrapper.exists(actual)).thenReturn(true);
  paths.assertExists(info,actual);
}
