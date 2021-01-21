@Test public void should_fail_if_file_does_not_have_expected_binary_content() throws IOException {
  BinaryDiffResult diff=new BinaryDiffResult(15,(byte)0xCA,(byte)0xFE);
  when(binaryDiff.diff(actual,expected)).thenReturn(diff);
  AssertionInfo info=someInfo();
  try {
    files.assertHasBinaryContent(info,actual,expected);
  }
 catch (  AssertionError e) {
    verify(failures).failure(info,shouldHaveBinaryContent(actual,diff));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
