@Test public void should_pass_if_file_has_expected_binary_content() throws IOException {
  when(binaryDiff.diff(actual,expected)).thenReturn(BinaryDiffResult.noDiff());
  files.assertHasBinaryContent(someInfo(),actual,expected);
}
