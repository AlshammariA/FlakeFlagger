@Test public void should_fail_if_path_does_not_have_expected_binary_content() throws IOException {
  BinaryDiffResult binaryDiffs=new BinaryDiffResult(15,(byte)0xCA,(byte)0xFE);
  when(binaryDiff.diff(path.toFile(),expected)).thenReturn(binaryDiffs);
  when(nioFilesWrapper.exists(path)).thenReturn(true);
  when(nioFilesWrapper.isReadable(path)).thenReturn(true);
  AssertionInfo info=someInfo();
  try {
    paths.assertHasBinaryContent(info,path,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveBinaryContent(path.toFile(),binaryDiffs));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
