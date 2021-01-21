@Test public void should_return_empty_diff_list_if_inputstreams_have_equal_content() throws IOException {
  actual=stream("base","line0","line1");
  expected=stream("base","line0","line1");
  List<String> diffs=diff.diff(actual,expected);
  assertEquals(0,diffs.size());
}
