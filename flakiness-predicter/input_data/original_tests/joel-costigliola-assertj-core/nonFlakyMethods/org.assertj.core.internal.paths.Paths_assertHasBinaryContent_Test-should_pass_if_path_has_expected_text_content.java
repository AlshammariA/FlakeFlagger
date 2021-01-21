@Test public void should_pass_if_path_has_expected_text_content() throws IOException {
  when(binaryDiff.diff(path.toFile(),expected)).thenReturn(noDiff());
  when(nioFilesWrapper.exists(path)).thenReturn(true);
  when(nioFilesWrapper.isReadable(path)).thenReturn(true);
  paths.assertHasBinaryContent(someInfo(),path,expected);
}
