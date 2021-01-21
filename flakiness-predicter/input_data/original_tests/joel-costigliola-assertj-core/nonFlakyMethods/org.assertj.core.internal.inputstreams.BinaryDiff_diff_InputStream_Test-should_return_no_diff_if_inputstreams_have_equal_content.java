@Test public void should_return_no_diff_if_inputstreams_have_equal_content() throws IOException {
  actual=stream(0xCA,0xFE,0xBA,0xBE);
  expected=stream(0xCA,0xFE,0xBA,0xBE);
  BinaryDiffResult result=binaryDiff.diff(actual,expected);
  assertTrue(result.hasNoDiff());
}
