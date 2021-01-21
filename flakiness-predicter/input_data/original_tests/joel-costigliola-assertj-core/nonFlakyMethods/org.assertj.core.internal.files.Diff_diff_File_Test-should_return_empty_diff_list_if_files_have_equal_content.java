@Test public void should_return_empty_diff_list_if_files_have_equal_content() throws IOException {
  String[] content=array("line0","line1");
  writer.write(actual,content);
  writer.write(expected,content);
  List<String> diffs=diff.diff(actual,expected);
  assertEquals(0,diffs.size());
}
