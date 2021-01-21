@Test public void should_return_empty_diff_list_if_file_and_string_have_equal_content() throws IOException {
  String[] content=array("line0","line1");
  writer.write(actual,content);
  String expected="line0\nline1";
  List<String> diffs=diff.diff(actual,expected,Charset.defaultCharset());
  assertEquals(0,diffs.size());
}
