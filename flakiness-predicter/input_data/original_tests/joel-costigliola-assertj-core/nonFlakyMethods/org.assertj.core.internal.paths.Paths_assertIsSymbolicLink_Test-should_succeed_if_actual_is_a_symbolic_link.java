@Test public void should_succeed_if_actual_is_a_symbolic_link(){
  when(nioFilesWrapper.exists(actual,LinkOption.NOFOLLOW_LINKS)).thenReturn(true);
  when(nioFilesWrapper.isSymbolicLink(actual)).thenReturn(true);
  paths.assertIsSymbolicLink(info,actual);
}
