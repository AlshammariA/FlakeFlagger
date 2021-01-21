@Test public void should_pass_if_file_has_text_content() throws IOException {
  when(diff.diff(actual,expected,charset)).thenReturn(new ArrayList<String>());
  files.assertHasContent(someInfo(),actual,expected,charset);
}
