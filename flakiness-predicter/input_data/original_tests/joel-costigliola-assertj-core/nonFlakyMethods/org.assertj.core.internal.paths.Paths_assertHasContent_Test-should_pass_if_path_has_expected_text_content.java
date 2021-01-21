@Test public void should_pass_if_path_has_expected_text_content() throws IOException {
  when(diff.diff(path.toFile(),expected,charset)).thenReturn(new ArrayList<String>());
  when(nioFilesWrapper.exists(path)).thenReturn(true);
  when(nioFilesWrapper.isReadable(path)).thenReturn(true);
  paths.assertHasContent(someInfo(),path,expected,charset);
}
