@Test public void should_fail_if_actual_exists_but_is_not_a_symbolic_link(){
  when(nioFilesWrapper.exists(actual,LinkOption.NOFOLLOW_LINKS)).thenReturn(true);
  when(nioFilesWrapper.isSymbolicLink(actual)).thenReturn(false);
  try {
    paths.assertIsSymbolicLink(info,actual);
    wasExpectingAssertionError();
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldBeSymbolicLink(actual));
  }
}
