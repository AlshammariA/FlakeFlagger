@Test public void should_pass_if_windows_file_is_split_into_lines_using_charset(){
  assertThat(linesOf(SAMPLE_WIN_FILE,UTF_8)).isEqualTo(EXPECTED_CONTENT);
}
